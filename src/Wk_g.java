package Wk;

import D.AbstractC0361z;
import DG.B;
import DG.E;
import M2.F;
import M2.S;
import Qr.C1501i;
import Qr.C1526q0;
import Rk.t;
import WC.AbstractC2174a;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import client_exporter.NotificationReceivedEvent;
import com.bumptech.glide.request.target.Target;
import com.squareup.wire.AnyMessage;
import com.squareup.wire.ProtoAdapter;
import ir.divar.R;
import ir.divar.account.login.entity.UserState;
import ir.divar.analytics.legacy.entity.LogEntityConstants;
import ir.divar.chat.notification.entity.ChatNotificationEvent;
import ir.divar.chat.notification.entity.Notification;
import ir.divar.chat.notification.entity.NotificationPayload;
import ir.divar.either.Either;
import java.util.Date;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import marketing.ServerSideDynamicLink;
import org.json.JSONException;
import org.json.JSONObject;
import p404fk.C4341w0;
import p670mm.p;
import p835r5.B0;
import p962uG.o;
import p998vD.s;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B f30565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f30566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p631ll.a f30567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p045Gf.a f30568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f30569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p857rj.d f30570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final B0 f30571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f30572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Tk.a f30573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rk.e f30574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s f30575k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Pr.b f30576l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C4341w0 f30577m;

    public g(B scope, Context context, p631ll.a chatPreferences, p045Gf.a loginRepository, i iVar, p857rj.d actionLogHelper, B0 b10, t tVar, Tk.a chatNotificationEventPublisher, Rk.e chatNotifHistory, s sVar, Pr.b featureManager, C4341w0 conversationIdPublisher) {
        k.i(scope, "scope");
        k.i(chatPreferences, "chatPreferences");
        k.i(loginRepository, "loginRepository");
        k.i(actionLogHelper, "actionLogHelper");
        k.i(chatNotificationEventPublisher, "chatNotificationEventPublisher");
        k.i(chatNotifHistory, "chatNotifHistory");
        k.i(featureManager, "featureManager");
        k.i(conversationIdPublisher, "conversationIdPublisher");
        this.f30565a = scope;
        this.f30566b = context;
        this.f30567c = chatPreferences;
        this.f30568d = loginRepository;
        this.f30569e = iVar;
        this.f30570f = actionLogHelper;
        this.f30571g = b10;
        this.f30572h = tVar;
        this.f30573i = chatNotificationEventPublisher;
        this.f30574j = chatNotifHistory;
        this.f30575k = sVar;
        this.f30576l = featureManager;
        this.f30577m = conversationIdPublisher;
    }

    public static void e(boolean z10) {
        Ts.b bVar = new Ts.b(z10 ? NotificationReceivedEvent.NotificationState.SUCCESS : NotificationReceivedEvent.NotificationState.NON_LOGIN, 15);
        Nm.g gVar = Lm.a.f16642a;
        if (gVar != null) {
            gVar.a(bVar);
        } else {
            k.r("instance");
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:46:0x0105  */
    /* JADX WARN: Code duplicated, block: B:50:0x0113  */
    /* JADX WARN: Code duplicated, block: B:52:0x0123  */
    /* JADX WARN: Code duplicated, block: B:58:0x0140  */
    /* JADX WARN: Code duplicated, block: B:61:0x015b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x015c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x015d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0136, code lost:
    
        if (d(r2, r0) == r1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Notification notification2, PE.c cVar) {
        b bVar;
        boolean z10;
        Notification notification3;
        int i10;
        int i11;
        Either fVar;
        Either either;
        Notification notification4;
        int i12;
        Either either2;
        int i13;
        boolean z11;
        Notification notification5;
        boolean zIsLogin;
        if (cVar instanceof b) {
            bVar = (b) cVar;
            int i14 = bVar.f30542h;
            if ((i14 & Target.SIZE_ORIGINAL) != 0) {
                bVar.f30542h = i14 - Target.SIZE_ORIGINAL;
            } else {
                bVar = new b(this, cVar);
            }
        } else {
            bVar = new b(this, cVar);
        }
        Object objR = bVar.f30540f;
        Object obj = OE.a.f19974a;
        int i15 = bVar.f30542h;
        JE.B b10 = JE.B.f13204a;
        B0 b11 = this.f30571g;
        if (i15 == 0) {
            p176a0.e.W(objR);
            g(notification2);
            String notificationId = notification2.getNotificationId();
            bVar.f30535a = notification2;
            bVar.f30542h = 1;
            objR = b11.R(notificationId, bVar);
            if (objR != obj) {
            }
            return obj;
        }
        if (i15 == 1) {
            notification2 = bVar.f30535a;
            p176a0.e.W(objR);
        } else {
            if (i15 == 2) {
                i10 = bVar.f30538d;
                z10 = bVar.f30539e;
                i11 = bVar.f30537c;
                notification3 = bVar.f30535a;
                p176a0.e.W(objR);
                either = (Either) objR;
                if (either instanceof Lr.e) {
                    Lr.e eVar = new Lr.e(((Lr.e) either).f16710a);
                    i12 = i10;
                    either2 = eVar;
                    i13 = i11;
                    z11 = z10;
                    notification5 = notification3;
                    if (either2 instanceof Lr.f) {
                        zIsLogin = ((UserState) ((Lr.f) either2).f16711a).isLogin();
                        e(zIsLogin);
                        if (zIsLogin) {
                            bVar.f30535a = notification5;
                            bVar.f30536b = (Lr.f) either2;
                            bVar.f30537c = i13;
                            bVar.f30539e = z11;
                            bVar.f30538d = i12;
                            bVar.f30542h = 4;
                        }
                    }
                } else {
                    if (either instanceof Lr.f) {
                        throw new NoWhenBranchMatchedException();
                    }
                    bVar.f30535a = notification3;
                    bVar.f30536b = null;
                    bVar.f30537c = i11;
                    bVar.f30539e = z10;
                    bVar.f30538d = i10;
                    bVar.f30542h = 3;
                    objR = ((p045Gf.k) this.f30568d).f9760b.a(bVar);
                    if (objR != obj) {
                        notification4 = notification3;
                        Either either3 = (Either) objR;
                        i12 = i10;
                        either2 = either3;
                        int i16 = i11;
                        z11 = z10;
                        notification5 = notification4;
                        i13 = i16;
                        if (either2 instanceof Lr.f) {
                            zIsLogin = ((UserState) ((Lr.f) either2).f16711a).isLogin();
                            e(zIsLogin);
                            if (zIsLogin) {
                                bVar.f30535a = notification5;
                                bVar.f30536b = (Lr.f) either2;
                                bVar.f30537c = i13;
                                bVar.f30539e = z11;
                                bVar.f30538d = i12;
                                bVar.f30542h = 4;
                            }
                        }
                    }
                }
                return obj;
            }
            if (i15 == 3) {
                i10 = bVar.f30538d;
                z10 = bVar.f30539e;
                i11 = bVar.f30537c;
                notification4 = bVar.f30535a;
                p176a0.e.W(objR);
                Either either4 = (Either) objR;
                i12 = i10;
                either2 = either4;
                int i17 = i11;
                z11 = z10;
                notification5 = notification4;
                i13 = i17;
                if (either2 instanceof Lr.f) {
                    zIsLogin = ((UserState) ((Lr.f) either2).f16711a).isLogin();
                    e(zIsLogin);
                    if (zIsLogin) {
                        bVar.f30535a = notification5;
                        bVar.f30536b = (Lr.f) either2;
                        bVar.f30537c = i13;
                        bVar.f30539e = z11;
                        bVar.f30538d = i12;
                        bVar.f30542h = 4;
                    }
                }
            } else {
                if (i15 != 4) {
                    if (i15 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p176a0.e.W(objR);
                    return b10;
                }
                either2 = bVar.f30536b;
                notification5 = bVar.f30535a;
                p176a0.e.W(objR);
            }
        }
        Notification notification6 = notification5;
        fVar = either2;
        notification2 = notification6;
        if (fVar instanceof Lr.e) {
            WC.f.b(null, 11, null, ((Lr.c) ((Lr.e) fVar).f16710a).getError());
        }
        bVar.f30535a = null;
        bVar.f30536b = null;
        bVar.f30542h = 5;
        if (b(notification2, bVar) == obj) {
            return obj;
        }
        return b10;
        Either either5 = (Either) objR;
        if (!(either5 instanceof Lr.e)) {
            if (!(either5 instanceof Lr.f)) {
                throw new NoWhenBranchMatchedException();
            }
            boolean zBooleanValue = ((Boolean) ((Lr.f) either5).f16711a).booleanValue();
            if (zBooleanValue) {
                fVar = new Lr.f(b10);
            } else {
                List listK = E6.b.K(notification2.getNotificationId());
                bVar.f30535a = notification2;
                bVar.f30537c = 0;
                bVar.f30539e = zBooleanValue;
                bVar.f30538d = 0;
                bVar.f30542h = 2;
                Object objZ = b11.Z(listK, bVar);
                if (objZ != obj) {
                    z10 = zBooleanValue;
                    objR = objZ;
                    notification3 = notification2;
                    i10 = 0;
                    i11 = 0;
                    either = (Either) objR;
                    if (either instanceof Lr.e) {
                        Lr.e eVar2 = new Lr.e(((Lr.e) either).f16710a);
                        i12 = i10;
                        either2 = eVar2;
                        i13 = i11;
                        z11 = z10;
                        notification5 = notification3;
                        if (either2 instanceof Lr.f) {
                            zIsLogin = ((UserState) ((Lr.f) either2).f16711a).isLogin();
                            e(zIsLogin);
                            if (zIsLogin) {
                                bVar.f30535a = notification5;
                                bVar.f30536b = (Lr.f) either2;
                                bVar.f30537c = i13;
                                bVar.f30539e = z11;
                                bVar.f30538d = i12;
                                bVar.f30542h = 4;
                            }
                        }
                        Notification notification7 = notification5;
                        fVar = either2;
                        notification2 = notification7;
                    } else {
                        if (either instanceof Lr.f) {
                            throw new NoWhenBranchMatchedException();
                        }
                        bVar.f30535a = notification3;
                        bVar.f30536b = null;
                        bVar.f30537c = i11;
                        bVar.f30539e = z10;
                        bVar.f30538d = i10;
                        bVar.f30542h = 3;
                        objR = ((p045Gf.k) this.f30568d).f9760b.a(bVar);
                        if (objR != obj) {
                            notification4 = notification3;
                            Either either6 = (Either) objR;
                            i12 = i10;
                            either2 = either6;
                            int i18 = i11;
                            z11 = z10;
                            notification5 = notification4;
                            i13 = i18;
                            if (either2 instanceof Lr.f) {
                                zIsLogin = ((UserState) ((Lr.f) either2).f16711a).isLogin();
                                e(zIsLogin);
                                if (zIsLogin) {
                                    bVar.f30535a = notification5;
                                    bVar.f30536b = (Lr.f) either2;
                                    bVar.f30537c = i13;
                                    bVar.f30539e = z11;
                                    bVar.f30538d = i12;
                                    bVar.f30542h = 4;
                                }
                            }
                            Notification notification8 = notification5;
                            fVar = either2;
                            notification2 = notification8;
                        }
                    }
                }
            }
            return obj;
        }
        fVar = new Lr.e(((Lr.e) either5).f16710a);
        if (fVar instanceof Lr.e) {
            WC.f.b(null, 11, null, ((Lr.c) ((Lr.e) fVar).f16710a).getError());
        }
        bVar.f30535a = null;
        bVar.f30536b = null;
        bVar.f30542h = 5;
        if (b(notification2, bVar) == obj) {
            return obj;
        }
        return b10;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(Notification notification2, PE.c cVar) {
        c cVar2;
        Either either;
        Either either2;
        if (cVar instanceof c) {
            cVar2 = (c) cVar;
            int i10 = cVar2.f30547e;
            if ((i10 & Target.SIZE_ORIGINAL) != 0) {
                cVar2.f30547e = i10 - Target.SIZE_ORIGINAL;
            } else {
                cVar2 = new c(this, cVar);
            }
        } else {
            cVar2 = new c(this, cVar);
        }
        Object objB = cVar2.f30545c;
        OE.a aVar = OE.a.f19974a;
        int i11 = cVar2.f30547e;
        if (i11 != 0) {
            if (i11 == 1) {
                notification2 = cVar2.f30543a;
                p176a0.e.W(objB);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                either2 = cVar2.f30544b;
                p176a0.e.W(objB);
            }
            either = either2;
            if (either instanceof Lr.e) {
                WC.f.b(null, 11, null, ((p) ((Lr.e) either).f16710a).getError());
            }
            return JE.B.f13204a;
        }
        p176a0.e.W(objB);
        String callbackUrl = notification2.getCallbackUrl();
        if (callbackUrl != null && !o.J(callbackUrl)) {
            String callbackUrl2 = notification2.getCallbackUrl();
            cVar2.f30543a = notification2;
            cVar2.f30547e = 1;
            objB = this.f30572h.f23774a.b(callbackUrl2, cVar2);
            if (objB != aVar) {
            }
            return aVar;
        }
        return JE.B.f13204a;
        either = (Either) objB;
        if (either instanceof Lr.f) {
            List listK = E6.b.K(notification2.getNotificationId());
            cVar2.f30543a = null;
            cVar2.f30544b = (Lr.f) either;
            cVar2.f30547e = 2;
            if (this.f30571g.h0(listK, true, cVar2) != aVar) {
                either2 = either;
                either = either2;
                if (either instanceof Lr.e) {
                    WC.f.b(null, 11, null, ((p) ((Lr.e) either).f16710a).getError());
                }
            }
            return aVar;
        }
        if (either instanceof Lr.e) {
            WC.f.b(null, 11, null, ((p) ((Lr.e) either).f16710a).getError());
        }
        return JE.B.f13204a;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(String str, String str2, NotificationPayload.ChatPayload chatPayload, PE.c cVar) {
        d dVar;
        if (cVar instanceof d) {
            dVar = (d) cVar;
            int i10 = dVar.f30553f;
            if ((i10 & Target.SIZE_ORIGINAL) != 0) {
                dVar.f30553f = i10 - Target.SIZE_ORIGINAL;
            } else {
                dVar = new d(this, cVar);
            }
        } else {
            dVar = new d(this, cVar);
        }
        Object objA = dVar.f30551d;
        OE.a aVar = OE.a.f19974a;
        int i11 = dVar.f30553f;
        JE.B b10 = JE.B.f13204a;
        if (i11 == 0) {
            p176a0.e.W(objA);
            if (((C1501i) this.f30576l.a(C1526q0.f23076a)).f23025a) {
                String messageId = chatPayload.getMessageId();
                String conversationId = chatPayload.getConversationId();
                dVar.f30548a = str;
                dVar.f30549b = str2;
                dVar.f30550c = chatPayload;
                dVar.f30553f = 1;
                objA = this.f30574j.a(messageId, conversationId, dVar);
                if (objA == aVar) {
                    return aVar;
                }
            }
            if (chatPayload.getCensored()) {
                str2 = this.f30566b.getString(R.string.chat_text_message_text);
            }
            k.f(str2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            S s9 = new S();
            s9.f17171a = str;
            s9.f17172b = null;
            s9.f17173c = null;
            s9.f17174d = null;
            s9.f17175e = false;
            s9.f17176f = false;
            F f10 = new F(str2, jCurrentTimeMillis, s9);
            String messageId2 = chatPayload.getMessageId();
            this.f30569e.b(f10, chatPayload.getConversationId(), messageId2);
            return b10;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        chatPayload = dVar.f30550c;
        str2 = dVar.f30549b;
        str = dVar.f30548a;
        p176a0.e.W(objA);
        if (!((Boolean) P.h.B((Either) objA, Boolean.FALSE)).booleanValue() || k.d(this.f30577m.f49794b.f9288a.getValue(), chatPayload.getConversationId())) {
            return b10;
        }
        if (chatPayload.getCensored()) {
            str2 = this.f30566b.getString(R.string.chat_text_message_text);
        }
        k.f(str2);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        S s10 = new S();
        s10.f17171a = str;
        s10.f17172b = null;
        s10.f17173c = null;
        s10.f17174d = null;
        s10.f17175e = false;
        s10.f17176f = false;
        F f11 = new F(str2, jCurrentTimeMillis2, s10);
        String messageId3 = chatPayload.getMessageId();
        this.f30569e.b(f11, chatPayload.getConversationId(), messageId3);
        return b10;
    }

    public final Object d(Notification notification2, PE.c cVar) {
        Object objC;
        i iVar = this.f30569e;
        Context context = iVar.f30580a;
        boolean z10 = this.f30567c.f63071a.getBoolean("notification", true);
        NotificationPayload payload = notification2.getPayload();
        boolean z11 = payload instanceof NotificationPayload.ChatPayload;
        JE.B b10 = JE.B.f13204a;
        if (z11) {
            if (z10 && (objC = c(notification2.getTitle(), notification2.getMessage(), (NotificationPayload.ChatPayload) notification2.getPayload(), cVar)) == OE.a.f19974a) {
                return objC;
            }
        } else if (payload instanceof NotificationPayload.PostmanPayload) {
            if (z10) {
                iVar.d(notification2.getNotificationId(), notification2.getTitle(), notification2.getMessage());
                return b10;
            }
        } else {
            if (payload instanceof NotificationPayload.ManagePayload) {
                String notificationId = notification2.getNotificationId();
                String token = ((NotificationPayload.ManagePayload) notification2.getPayload()).getToken();
                String message = notification2.getMessage();
                String title = notification2.getTitle();
                k.i(notificationId, "notificationId");
                k.i(message, "message");
                k.i(title, "title");
                k.i(token, "token");
                String strConcat = "divar://manage/?mng_token=".concat(token);
                Intent intent = new Intent();
                intent.setData(Uri.parse(strConcat));
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268468224);
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
                k.h(activity, "getActivity(...)");
                iVar.c(notificationId, message, title, activity);
                return b10;
            }
            if (payload instanceof NotificationPayload.DynamicActionPayload) {
                String notificationId2 = notification2.getNotificationId();
                NotificationPayload.DynamicActionPayload payload2 = (NotificationPayload.DynamicActionPayload) notification2.getPayload();
                String message2 = notification2.getMessage();
                String title2 = notification2.getTitle();
                k.i(notificationId2, "notificationId");
                k.i(message2, "message");
                k.i(title2, "title");
                k.i(payload2, "payload");
                AnyMessage params = payload2.getServerSideDynamicLink().getParams();
                String strN = params != null ? AbstractC2174a.n(params.encode()) : null;
                String slug = payload2.getServerSideDynamicLink().getSlug();
                if (strN == null) {
                    strN = "";
                }
                String strF = AbstractC0361z.f("divar://dynamic_action?slug=", slug, "&params=", strN);
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse(strF));
                intent2.setAction("android.intent.action.VIEW");
                intent2.setFlags(268468224);
                PendingIntent activity2 = PendingIntent.getActivity(context, 0, intent2, 201326592);
                k.h(activity2, "getActivity(...)");
                iVar.c(notificationId2, message2, title2, activity2);
                return b10;
            }
            if (payload instanceof NotificationPayload.VoIPPayload) {
                NotificationPayload.VoIPPayload voIPPayload = (NotificationPayload.VoIPPayload) notification2.getPayload();
                if (voIPPayload.getCallPublicId() != null) {
                    E.E(this.f30565a, null, null, new f(this, voIPPayload, null), 3);
                }
            }
        }
        return b10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:121:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:6:0x0020  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final void f(JSONObject jSONObject, String body, String title) {
        String strOptString;
        JSONObject jSONObject2;
        String strOptString2;
        String strOptString3;
        String notificationId;
        JSONObject jSONObject3;
        NotificationPayload managePayload;
        NotificationPayload chatPayload;
        Context context = this.f30566b;
        k.i(body, "body");
        k.i(title, "title");
        if (jSONObject != null) {
            try {
                strOptString = jSONObject.optString("push_id");
                if (strOptString == null) {
                    strOptString = "";
                }
            } catch (Throwable unused) {
                return;
            }
        } else {
            strOptString = "";
        }
        if (title.equals("") || !title.equals(strOptString)) {
            jSONObject2 = null;
        } else {
            try {
                jSONObject2 = new JSONObject(body);
            } catch (Throwable unused2) {
                jSONObject2 = null;
            }
        }
        if (jSONObject2 != null && !k.d(jSONObject2.optString("callback_url"), "") && !k.d(jSONObject2.optString("campaign"), "") && !k.d(jSONObject2.optString("action"), "")) {
            String strOptString4 = jSONObject2.optString("campaign");
            context.sendBroadcast(new Intent().setClassName(context, jSONObject2.getString("action")).setData(Uri.parse(strOptString4)).putExtra(strOptString4, strOptString4));
            return;
        }
        if (jSONObject == null || (strOptString2 = jSONObject.optString("action")) == null) {
            strOptString2 = "";
        }
        if (o.J(title) && !strOptString2.equals("silent")) {
            Ru.f fVar = new Ru.f(19);
            Nm.g gVar = Lm.a.f16642a;
            if (gVar != null) {
                gVar.a(fVar);
                return;
            } else {
                k.r("instance");
                throw null;
            }
        }
        if (jSONObject == null || (strOptString3 = jSONObject.optString("action")) == null) {
            strOptString3 = "";
        }
        if (jSONObject == null || (notificationId = jSONObject.optString("push_id")) == null) {
            notificationId = "";
        }
        String strOptString5 = jSONObject != null ? jSONObject.optString("callback_url") : null;
        if (jSONObject != null) {
            try {
                String strOptString6 = jSONObject.optString("param", "");
                if (strOptString6 != null) {
                    jSONObject3 = new JSONObject(strOptString6);
                } else {
                    jSONObject3 = null;
                }
            } catch (JSONException e10) {
                WC.f.b(null, 11, null, e10);
            }
        } else {
            jSONObject3 = null;
        }
        String strOptString7 = jSONObject3 != null ? jSONObject3.optString("message_id") : null;
        if (notificationId.length() == 0) {
            notificationId = (strOptString7 == null || o.J(strOptString7)) ? String.valueOf(new Date().getTime() % ((long) Integer.MAX_VALUE)) : strOptString7;
        }
        String strOptString8 = jSONObject3 != null ? jSONObject3.optString("campaign") : null;
        String strOptString9 = jSONObject3 != null ? jSONObject3.optString(LogEntityConstants.f56311ID) : null;
        String strOptString10 = jSONObject3 != null ? jSONObject3.optString("mng_token") : null;
        boolean zOptBoolean = jSONObject3 != null ? jSONObject3.optBoolean("censored") : false;
        String strOptString11 = jSONObject3 != null ? jSONObject3.optString("dynamic_link") : null;
        String strOptString12 = jSONObject3 != null ? jSONObject3.optString("call_public_id") : null;
        k.i(notificationId, "notificationId");
        switch (strOptString3.hashCode()) {
            case -1081434779:
                if (!strOptString3.equals("manage")) {
                    managePayload = null;
                } else {
                    managePayload = new NotificationPayload.ManagePayload(strOptString10 != null ? strOptString10 : "");
                }
                break;
            case -902327211:
                if (!strOptString3.equals("silent")) {
                    managePayload = null;
                } else {
                    managePayload = NotificationPayload.SilentPayload.INSTANCE;
                }
                break;
            case -391207932:
                if (!strOptString3.equals("postchi")) {
                    managePayload = null;
                } else {
                    managePayload = new NotificationPayload.PostmanPayload(null, 1, 0 == true ? 1 : 0);
                }
                break;
            case 3052376:
                if (!strOptString3.equals("chat")) {
                    managePayload = null;
                } else {
                    if (strOptString7 == null) {
                        strOptString7 = "";
                    }
                    chatPayload = new NotificationPayload.ChatPayload(strOptString7, zOptBoolean, strOptString9 != null ? strOptString9 : "");
                    managePayload = chatPayload;
                }
                break;
            case 3625376:
                if (!strOptString3.equals("voip")) {
                    managePayload = null;
                } else {
                    managePayload = new NotificationPayload.VoIPPayload(strOptString12);
                }
                break;
            case 2124767295:
                if (!strOptString3.equals("dynamic")) {
                    managePayload = null;
                } else {
                    ProtoAdapter<ServerSideDynamicLink> protoAdapter = ServerSideDynamicLink.ADAPTER;
                    byte[] bytes = (strOptString11 != null ? strOptString11 : "").getBytes();
                    chatPayload = new NotificationPayload.DynamicActionPayload(protoAdapter.decode(AbstractC2174a.i(bytes, AbstractC2174a.f30340c, bytes.length)));
                    managePayload = chatPayload;
                }
                break;
            default:
                managePayload = null;
                break;
        }
        if (managePayload == null) {
            return;
        }
        E.E(this.f30565a, null, null, new e(this, new Notification(title, strOptString3, body, strOptString8, strOptString5, notificationId, managePayload), null), 3);
    }

    public final void g(Notification notification2) {
        NotificationPayload payload = notification2.getPayload();
        boolean z10 = payload instanceof NotificationPayload.ChatPayload;
        p857rj.d dVar = this.f30570f;
        Tk.a aVar = this.f30573i;
        if (z10) {
            ChatNotificationEvent.Chat event = ChatNotificationEvent.Chat.INSTANCE;
            aVar.getClass();
            k.i(event, "event");
            aVar.f27465a.onNext(event);
            String campaign = notification2.getCampaign();
            String notificationId = notification2.getNotificationId();
            String notificationId2 = notification2.getNotificationId();
            String conversationId = ((NotificationPayload.ChatPayload) notification2.getPayload()).getConversationId();
            dVar.getClass();
            p857rj.d.a("received", notificationId, notificationId2, false, conversationId, campaign);
            return;
        }
        if (!(payload instanceof NotificationPayload.PostmanPayload)) {
            String title = notification2.getTitle();
            String message = notification2.getMessage();
            String notificationId3 = notification2.getNotificationId();
            String action = notification2.getAction();
            String campaign2 = notification2.getCampaign();
            String notificationId4 = notification2.getNotificationId();
            dVar.getClass();
            p857rj.d.b("received", title, notificationId3, action, message, campaign2, notificationId4);
            return;
        }
        ChatNotificationEvent.Postman event2 = ChatNotificationEvent.Postman.INSTANCE;
        aVar.getClass();
        k.i(event2, "event");
        aVar.f27465a.onNext(event2);
        String campaign3 = notification2.getCampaign();
        String notificationId5 = notification2.getNotificationId();
        String notificationId6 = notification2.getNotificationId();
        dVar.getClass();
        p857rj.d.c("received", notificationId5, notificationId6, false, "", campaign3);
    }
}
