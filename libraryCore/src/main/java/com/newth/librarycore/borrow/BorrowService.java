package com.newth.librarycore.borrow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BorrowService {
    @GET("/reader/book_lst.php")
    Call<String> getBorrowBook();

    @GET("/reader/ajax_renew.php")
    Call<String> reNewBook(@Query("bar_code") String barcode,
                           @Query("check") String check,
                           @Query("captcha") String captcha,
                           @Query("time") String time);

    @GET("/reader/book_hist.php")
    Call<String> getHistoryBooks(@Query("page") String page);
}
