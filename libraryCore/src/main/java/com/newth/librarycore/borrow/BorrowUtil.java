package com.newth.librarycore.borrow;

import com.newth.librarycore.JsoupUtil;
import com.newth.librarycore.retrofit.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.newth.librarycore.login.CookieClient.setCookieClient;

public class BorrowUtil {
    public static void getBorrowBook(String cookie, final OnBorrowNowResponse nowResponse){
        BorrowService service= RetrofitManager.getInstance().getService(BorrowService.class,setCookieClient(cookie),RetrofitManager.ConvertType_String);
        Call<String> response=service.getBorrowBook();
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                nowResponse.getBorrowInfo(JsoupUtil.parseBorrowBookInfo(response.body()));
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    public static void reNewBook(String cookie, String barcode, String check, String captcha, final OnReNewBookResponse reNewBookResponse){
        BorrowService service=RetrofitManager.getInstance().getService(BorrowService.class,setCookieClient(cookie),RetrofitManager.ConvertType_String);
        Call<String> response=service.reNewBook(barcode,check,captcha,String.valueOf(System.currentTimeMillis()));
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                reNewBookResponse.getRenewInfo(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    public static void getBorrowHistory(String cookie, String page, final OnBorrowHistoryResponse historyResponse){
        BorrowService service=RetrofitManager.getInstance().getService(BorrowService.class,setCookieClient(cookie),RetrofitManager.ConvertType_String);
        Call<String> response=service.getHistoryBooks(page);
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    historyResponse.getBorrowHistory(JsoupUtil.praseHistoryBooks(response.body()));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
