package me.racofix.eyes.api;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zjl on 16-9-12.
 */
public interface ApiService {

    // 每日精选
    @GET("v2/feed")
    Call<Response> onRecviceChoice2Api(@Query("num") int num);

}
