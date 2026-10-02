package ir.divar.chat.notification.firebase;

import JE.p;
import Wk.g;
import Zk.z;
import androidx.lifecycle.B0;
import androidx.lifecycle.y0;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.webengage.sdk.android.WebEngage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.Type;
import p035Fc.i;
import p051Hc.b;
import p1076xa.l;
import p165Ye.C2345h0;
import p165Ye.t0;
import p175a.a;
import p986v0.C5941e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lir/divar/chat/notification/firebase/DivarFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = Type.DNSKEY)
public final class DivarFirebaseMessagingService extends FirebaseMessagingService implements b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile i f56721g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public B0 f56724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f56725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y0 f56726l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f56722h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56723i = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p f56727m = a.X(new Ts.b(this, 8));

    @Override // p051Hc.b
    public final Object c() {
        if (this.f56721g == null) {
            synchronized (this.f56722h) {
                try {
                    if (this.f56721g == null) {
                        this.f56721g = new i(this);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f56721g.c();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void d(l lVar) throws JSONException {
        Map<String, String> mapC = lVar.c();
        k.h(mapC, "getData(...)");
        C5941e c5941e = (C5941e) mapC;
        String str = c5941e.containsKey("source") ? (String) c5941e.get("source") : "";
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode == -631187531) {
                if (str.equals("webengage")) {
                    WebEngage.get().receive(mapC);
                    return;
                }
                return;
            }
            if (iHashCode != 95596674) {
                if (iHashCode != 1544803905 || !str.equals("default")) {
                    return;
                }
            } else if (!str.equals("divar")) {
                return;
            }
            Map mapC2 = lVar.c();
            k.h(mapC2, "getData(...)");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((C5941e) mapC2).entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            g gVar = this.f56725k;
            if (gVar == null) {
                k.r("notificationProvider");
                throw null;
            }
            String strOptString = jSONObject.optString("body");
            k.h(strOptString, "optString(...)");
            String strOptString2 = jSONObject.optString("title");
            k.h(strOptString2, "optString(...)");
            gVar.f(jSONObject, strOptString, strOptString2);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void e(String token) {
        k.i(token, "token");
        WebEngage.get().setRegistrationID(token);
        z zVar = (z) this.f56727m.getValue();
        zVar.getClass();
        zVar.f33812e.f23760a.edit().putString("push_token", token).apply();
        zVar.j();
    }

    @Override // android.app.Service
    public final void onCreate() {
        if (!this.f56723i) {
            this.f56723i = true;
            t0 t0Var = ((C2345h0) ((Uk.a) c())).f32397a;
            this.f56724j = (B0) t0Var.f32479M1.get();
            this.f56725k = t0Var.B();
            this.f56726l = (y0) t0Var.f32474L1.get();
        }
        super.onCreate();
    }
}
