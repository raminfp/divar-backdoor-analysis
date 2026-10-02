package Wk;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import ir.divar.chat.notification.provider.ChatPushNotificationOpenHandler;
import p165Ye.t0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f30578a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f30579b = new Object();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f30578a) {
            return;
        }
        synchronized (this.f30579b) {
            try {
                if (!this.f30578a) {
                    ComponentCallbacks2 componentCallbacks2J = G8.a.j(context.getApplicationContext());
                    boolean z10 = componentCallbacks2J instanceof p051Hc.b;
                    Class<?> cls = componentCallbacks2J.getClass();
                    if (!z10) {
                        throw new IllegalArgumentException("Hilt BroadcastReceiver must be attached to an @HiltAndroidApp Application. Found: " + cls);
                    }
                    ((ChatPushNotificationOpenHandler) this).f56736c = (p857rj.d) ((t0) ((a) ((p051Hc.b) componentCallbacks2J).c())).f32610m2.get();
                    this.f30578a = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
