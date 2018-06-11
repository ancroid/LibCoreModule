package com.newth.librarycore.retrofit;

import com.newth.librarycore.retrofit.converter.StringConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitManager {

    public static final int ConvertType_String=1;
    public static final int ConvertType_ResponseBody=2;
    public static final int ConvertType_Other=3;
    private static class Inner{
        static RetrofitManager manager=new RetrofitManager();
    }
    public static RetrofitManager getInstance(){
        return Inner.manager;
    }
    private RetrofitManager(){}

    public <T> T getService(Class<T> apiService,OkHttpClient okHttpClient,int converttype){
        Retrofit.Builder retrofit = new Retrofit.Builder();
        retrofit.baseUrl(Api.LIB_BASE_URL);
        if (okHttpClient!=null){
            retrofit.client(okHttpClient);
        }
        switch (converttype){
            case 1:
                retrofit.addConverterFactory(StringConverterFactory.create());
                break;
            case 2:
                retrofit.addConverterFactory(GsonConverterFactory.create());
                break;
            case 3:
                retrofit.addConverterFactory(GsonConverterFactory.create());
                break;
            default:
                break;
        }
        return retrofit.build().create(apiService);
    }
}
