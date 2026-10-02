package ir.divar.chat.notification.onesingnal;

import D.P0;
import H4.z;
import J3.a;
import Vk.d;
import Wk.g;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.onesignal.A0;
import com.onesignal.AbstractC3669r0;
import com.onesignal.AbstractC3677v0;
import com.onesignal.F;
import com.onesignal.Q0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.Type;
import p035Fc.i;
import p051Hc.b;
import p165Ye.C2345h0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lir/divar/chat/notification/onesingnal/PushNotificationExtender;", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = Type.DNSKEY)
public final class PushNotificationExtender extends F implements b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f56728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56729i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f56730j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile i f56732l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g f56735o;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Y2.b f56731k = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f56733m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f56734n = false;

    public static Intent g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent().setAction("com.onesignal.NotificationExtender").setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (listQueryIntentServices.size() < 1) {
            return null;
        }
        intent.setComponent(new ComponentName(context, listQueryIntentServices.get(0).serviceInfo.name));
        return intent;
    }

    @Override // p051Hc.b
    public final Object c() {
        if (this.f56732l == null) {
            synchronized (this.f56733m) {
                try {
                    if (this.f56732l == null) {
                        this.f56732l = new i(this);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f56732l.c();
    }

    @Override // com.onesignal.F
    public final void e(Intent intent) throws Throwable {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            AbstractC3669r0.a(3, "No extras sent to NotificationExtenderService in its Intent!\n" + intent, null);
        } else {
            String string = extras.getString("json_payload");
            if (string == null) {
                AbstractC3669r0.a(3, "json_payload key is nonexistent from bundle passed to NotificationExtenderService: " + extras, null);
            } else {
                try {
                    this.f56728h = new JSONObject(string);
                    this.f56729i = extras.getBoolean("restoring", false);
                    if (extras.containsKey("android_notif_id")) {
                        Y2.b bVar = new Y2.b(6, false);
                        this.f56731k = bVar;
                        bVar.f31606b = Integer.valueOf(extras.getInt("android_notif_id"));
                    }
                    if (this.f56729i || !AbstractC3669r0.t(this.f56728h, this)) {
                        this.f56730j = Long.valueOf(extras.getLong("timestamp"));
                        h(this.f56728h, this.f56729i);
                    }
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }
        a.a(intent);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public final void h(JSONObject jSONObject, boolean z10) throws Throwable {
        Integer num;
        Integer num2;
        z zVarA = AbstractC3677v0.a(jSONObject);
        String str = AbstractC3669r0.f42966a;
        try {
            g gVar = this.f56735o;
            if (gVar == null) {
                k.r("notificationProvider");
                throw null;
            }
            String body = (String) zVarA.f10531f;
            k.h(body, "body");
            String title = (String) zVarA.f10530e;
            k.h(title, "title");
            gVar.f((JSONObject) zVarA.f10532g, body, title);
            int iIntValue = -1;
            if (z10) {
                Y2.b bVar = this.f56731k;
                if (bVar != null) {
                    if (((bVar == null || (num2 = (Integer) bVar.f31606b) == null) ? -1 : num2.intValue()) != -1) {
                        StringBuilder sb = new StringBuilder("android_notification_id = ");
                        if (bVar != null && (num = (Integer) bVar.f31606b) != null) {
                            iIntValue = num.intValue();
                        }
                        sb.append(iIntValue);
                        String string = sb.toString();
                        A0 a0D = A0.d(this);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("dismissed", (Integer) 1);
                        a0D.U("notification", contentValues, string, null);
                        Q0.I(this);
                    }
                }
            } else {
                P0 p2 = new P0(this);
                p2.f4502e = jSONObject;
                Y2.b bVar2 = new Y2.b(6, false);
                p2.f4504g = bVar2;
                bVar2.f31606b = -1;
                AbstractC3677v0.q(p2, true);
                AbstractC3669r0.q(new JSONArray().put(jSONObject), false);
            }
            if (z10) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            AbstractC3669r0.a(3, "onNotificationProcessing throw an exception. Displaying normal OneSignal notification.", th2);
            if (AbstractC3677v0.t(jSONObject.optString("alert"))) {
                P0 p10 = new P0(this);
                p10.f4498a = this.f56729i;
                p10.f4502e = this.f56728h;
                p10.f4503f = this.f56730j;
                p10.f4504g = this.f56731k;
                AbstractC3677v0.c(p10);
            }
            if (z10) {
                Thread.sleep(100);
            }
        }
    }

    @Override // com.onesignal.F, android.app.Service
    public final void onCreate() {
        if (!this.f56734n) {
            this.f56734n = true;
            this.f56735o = ((C2345h0) ((d) c())).f32397a.B();
        }
        super.onCreate();
    }
}
