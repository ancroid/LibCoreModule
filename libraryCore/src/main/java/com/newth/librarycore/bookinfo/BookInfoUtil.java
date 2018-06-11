package com.newth.librarycore.bookinfo;

import com.newth.librarycore.JsoupUtil;
import com.newth.librarycore.retrofit.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookInfoUtil {
    /**
     * 从学校图书馆获取数据
     *
     * @param marcNo:图书对应的MarcNO值
     * @param bookInfoResponse:回调接口
     */
    public static void getBookInfoFromLib(String  marcNo, final OnBookInfoResponse bookInfoResponse) {
        InfoService getBookServise = RetrofitManager.getInstance().getService(InfoService.class,null,RetrofitManager.ConvertType_String);
        Call<String> call = getBookServise.getBookInfoFromLib(marcNo);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    bookInfoResponse.getResponse(JsoupUtil.parseBookInfo(response.body()));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
