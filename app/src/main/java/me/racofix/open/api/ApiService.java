package me.racofix.open.api;

import retrofit2.Call;
import retrofit2.http.GET;

import me.racofix.open.model.Discovery;
import me.racofix.open.model.Home;
import rx.Observable;

/**
 * Created by zjl on 16-9-12.
 */
public interface ApiService {

    String BASE_URL = "http://baobab.wandoujia.com/api/";

    // 每日精选
    @GET("v3/tabs/selected")
    Call<Home> onHomeDataStore2Api();

    // 发现
    @GET("v3/discovery")
    Call<Discovery> onCategoryData2Api();


}
