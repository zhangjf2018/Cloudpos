package com.ymt.cloudpos.test;


import com.ymt.cloudpos.core.secure.api.SResp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface RetrofitService {
    @Headers({
        "User-Agent: Android"
    })

    @GET("book/search")
    Call<Book> getSearchBooks(@Query("q") String name,
                                    @Query("tag") String tag, @Query("start") int start,
                                    @Query("count") int count);

    @POST("/xrtut/echo")
    Call<SResp> postQuery(@Body String body);
}
