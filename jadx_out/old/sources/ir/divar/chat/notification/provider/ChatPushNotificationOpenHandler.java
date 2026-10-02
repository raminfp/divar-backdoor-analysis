package ir.divar.chat.notification.provider;

import WC.f;
import Wk.h;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import ir.cafebazaar.bazaarpay.launcher.normal.PaymentURLParser;
import ir.divar.analytics.legacy.entity.LogEntityConstants;
import ir.divar.chat.notification.entity.NotificationPayload;
import ir.divar.chat.notification.entity.PushNotificationEntity;
import ir.divar.chat.util.ReportDeserializer;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import org.xbill.DNS.Type;
import p857rj.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lir/divar/chat/notification/provider/ChatPushNotificationOpenHandler;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = Type.DNSKEY)
public final class ChatPushNotificationOpenHandler extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f56736c;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:78:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ef  */
    @Override // Wk.h, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intent intent2;
        String string;
        Uri uri;
        super.onReceive(context, intent);
        k.i(context, "context");
        k.i(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        try {
            String dataString = intent.getDataString();
            if (dataString != null && k.d(extras.getString(dataString), dataString)) {
                new Thread(new ReportDeserializer(context, dataString)).start();
                return;
            }
            String string2 = extras.getString("PARAM");
            PushNotificationEntity pushNotificationEntity = (PushNotificationEntity) extras.getParcelable("ENTITY");
            if (pushNotificationEntity == null) {
                return;
            }
            NotificationPayload payload = pushNotificationEntity.getPayload();
            if (payload instanceof NotificationPayload.ChatPayload) {
                if (this.f56736c == null) {
                    k.r("actionLogHelper");
                    throw null;
                }
                d.a("open", pushNotificationEntity.getPushId(), pushNotificationEntity.getNotificationId(), false, ((NotificationPayload.ChatPayload) pushNotificationEntity.getPayload()).getConversationId(), pushNotificationEntity.getCampaign());
            } else if (payload instanceof NotificationPayload.PostmanPayload) {
                if (this.f56736c == null) {
                    k.r("actionLogHelper");
                    throw null;
                }
                d.c("open", pushNotificationEntity.getPushId(), pushNotificationEntity.getNotificationId(), false, ((NotificationPayload.PostmanPayload) pushNotificationEntity.getPayload()).getConversationId(), pushNotificationEntity.getCampaign());
            } else {
                if (this.f56736c == null) {
                    k.r("actionLogHelper");
                    throw null;
                }
                d.b("open", pushNotificationEntity.getTitle(), pushNotificationEntity.getPushId(), pushNotificationEntity.getAction(), pushNotificationEntity.getBody(), pushNotificationEntity.getCampaign(), pushNotificationEntity.getNotificationId());
            }
            if (TextUtils.isEmpty(pushNotificationEntity.getAction())) {
                intent2 = new Intent("android.intent.action.VIEW", Uri.parse("divar://home/"));
                intent2.setPackage(context.getApplicationContext().getPackageName());
                intent2.setFlags(268435456);
            } else {
                String action = pushNotificationEntity.getAction();
                JSONObject jSONObject = string2 != null ? new JSONObject(string2) : null;
                intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                if (action.length() > 0 && !action.equals("url")) {
                    if (jSONObject == null) {
                        uri = Uri.parse("divar://" + action + '/');
                        k.h(uri, "parse(...)");
                    } else {
                        StringBuilder sb = new StringBuilder("divar://");
                        switch (action) {
                            case "dialog":
                                StringBuilder sbM = d6.h.m(action, "/?text=");
                                sbM.append(jSONObject.optString("text"));
                                string = sbM.toString();
                                break;
                            case "manage":
                                StringBuilder sbM2 = d6.h.m(action, "/?mng_token=");
                                sbM2.append(jSONObject.optString("mng_token"));
                                string = sbM2.toString();
                                break;
                            case "meta_update":
                            case "update":
                            case "my_posts":
                            case "postchi":
                                string = action.concat("/");
                                break;
                            case "chat":
                                StringBuilder sbM3 = d6.h.m(action, "/?conversation_id=");
                                sbM3.append(jSONObject.optString(LogEntityConstants.f56311ID));
                                string = sbM3.toString();
                                break;
                            case "view":
                                string = "v/?token=" + jSONObject.optString(PaymentURLParser.CHECKOUT_TOKEN);
                                break;
                            case "category":
                                StringBuilder sbM4 = d6.h.m(action, "/?catSlug=");
                                sbM4.append(jSONObject.optString("catSlug"));
                                string = sbM4.toString();
                                break;
                            case "webview":
                                StringBuilder sbM5 = d6.h.m(action, "/?page_name=");
                                sbM5.append(jSONObject.optString("url"));
                                string = sbM5.toString();
                                break;
                            case "new_post":
                                string = action.concat("/");
                                break;
                            default:
                                string = "";
                                break;
                        }
                        sb.append(string);
                        uri = Uri.parse(sb.toString());
                        k.h(uri, "parse(...)");
                    }
                    intent2.setData(uri);
                } else if (jSONObject != null) {
                    intent2.setData(Uri.parse(jSONObject.optString("url")));
                }
                intent2.setFlags(335675392);
            }
            try {
                context.startActivity(intent2);
            } catch (ActivityNotFoundException e10) {
                f.b(null, 11, null, e10);
            }
        } catch (Throwable unused) {
        }
    }
}
