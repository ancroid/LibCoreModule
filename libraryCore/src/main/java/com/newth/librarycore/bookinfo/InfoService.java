package com.newth.librarycore.bookinfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InfoService {
    @GET("opac/item.php")
    Call<String> getBookInfoFromLib(@Query("marc_no") String marc_no);
}
