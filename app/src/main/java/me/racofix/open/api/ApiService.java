package me.racofix.open.api;


import me.racofix.open.model.Discovery;
import me.racofix.open.model.Home;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zjl on 16-9-12.
 */
public interface ApiService {

    String BASE_URL ="http://baobab.wandoujia.com/api/";

    // 每日精选
    @GET("v3/tabs/selected")
    Observable<Home> onHomeDataStore2Api();

    // 发现
    @GET("v3/discovery")
    Observable<Discovery> onCategoryData2Api();

}
