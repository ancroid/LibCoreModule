package com.newth.librarycore.login;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.newth.librarycore.JsoupUtil;
import com.newth.librarycore.retrofit.RetrofitManager;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import static com.newth.librarycore.login.CookieClient.getCookieIntercept;
import static com.newth.librarycore.login.CookieClient.setCookieClient;
import static com.newth.librarycore.retrofit.RetrofitManager.ConvertType_ResponseBody;
import static com.newth.librarycore.retrofit.RetrofitManager.ConvertType_String;

public class LoginLibUtil {

    public static void LoginToLib(String cookie,String number, String passwd, final String captcha, final OnLoginResponse loginResponse) {
        loginService service= RetrofitManager.getInstance().getService(loginService.class,setCookieClient(cookie),ConvertType_String);
        Call<String> call = service.login(number, passwd, captcha, "cert_no");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                loginResponse.getResponse(JsoupUtil.parseLoginInfo(response.body(),captcha));
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


    public static void getCaptcha(String cookie,final OnCaptchaResponse captchaResponse) {
        loginService service = RetrofitManager.getInstance().getService(loginService.class,setCookieClient(cookie),ConvertType_ResponseBody);
        Call<ResponseBody> call = service.getCaptcha();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if (response.code() == 200) {
                    Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
                    captchaResponse.getCaptcha(bitmap);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public static void getCookie(final OnCookieResponse cookieResponse) {
        loginService service = RetrofitManager.getInstance().getService(loginService.class,getCookieIntercept(new OnCookieResponse() {
            @Override
            public void getCookie(String cookie) {
                cookieResponse.getCookie(cookie);
            }
        }),ConvertType_String);
        Call<String> call = service.getCookie();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }
}
