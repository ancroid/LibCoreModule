# libraryCore （图书馆爬虫工具类集合）
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)

---

# 下载

1）下载project导入其中的module：libraryCore。

2）通过maven

    <dependency>
      <groupId>com.ancroid</groupId>
      <artifactId>libraryCore</artifactId>
      <version>1.0.0</version>
      <type>pom</type>
    </dependency>

3）通过gradle

    implementation 'com.ancroid:libraryCore:1.0.0'

---

# 使用
## 功能

 - login：获取cookie、获取验证码、登录
 - bookinfo：获取图书详情
 - borrow：获取已借、续借、获取借阅历史

## forExample

获取Cookie: LoginLibUtil.getCookie(OnCookieResponse cookieResponse)
``` java
    LoginLibUtil.getCookie(new OnCookieResponse() {
        @Override
        public void getCookie(String cookie) {
            Log.d("main", "getCookie: "+cookie);
        }
    });
```
获取验证码: LoginLibUtil.getCaptcha(String cookie,OnCaptchaResponse captchaResponse)
``` java
    LoginLibUtil.getCaptcha(Util.readCookieFromSP(),new OnCaptchaResponse() {
        @Override
        public void getCaptcha(Bitmap bitmap) {
            image.setImageBitmap(bitmap);
        }
    });
```

获取已借：BorrowUtil.getBorrowBook(String cookie,OnBorrowNowResponse nowResponse)

``` java
    BorrowUtil.getBorrowBook(Util.readCookieFromSP(), new OnBorrowNowResponse() {
        @Override
        public void getBorrowInfo(BorrowBookInfo bookInfo) {
            Log.d("main", "getBorrowInfo: "+bookInfo.getBorrowInfo());
        }
    });
```

更多API使用请参考项目中com.newth.libcoremoudle.debug.MainActivity的调用。
关于图书馆接口使用机制请参考：https://www.zybuluo.com/universal/note/1179033
