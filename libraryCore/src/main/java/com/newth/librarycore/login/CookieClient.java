package com.newth.librarycore.login;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class CookieClient {
    public static OkHttpClient getCookieIntercept(final OnCookieResponse cookieResponse) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                List<String> cookies = response.headers("Set-Cookie");
                if (cookies != null && cookies.size() > 0) {
                    String cookie = cookies.get(0);
                    cookieResponse.getCookie(cookie);
                }
                return response;
            }
        });
        return builder.build();
    }
    public static OkHttpClient setCookieClient(final String cookie) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                if (cookie != null && !cookie.equals("")) {
                    return chain.proceed(chain.request().newBuilder().header("Cookie", cookie).build());
                }
                return chain.proceed(chain.request());
            }
        });
        return builder.build();
    }


}
