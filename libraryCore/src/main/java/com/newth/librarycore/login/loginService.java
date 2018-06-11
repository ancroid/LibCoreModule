package com.newth.librarycore.login;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface loginService   {
    @FormUrlEncoded
    @POST("/reader/redr_verify.php")
    Call<String> login(@Field("number") String number,
                       @Field("passwd") String passwd,
                       @Field("captcha") String captcha,
                       @Field("select") String select);


    @GET("/reader/redr_verify.php")
    Call<String> getCookie();

    @GET("/reader/captcha.php")
    Call<ResponseBody> getCaptcha();
}
