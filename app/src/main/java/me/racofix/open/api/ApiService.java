package me.racofix.open.api;


import me.racofix.open.model.HomeRepo;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zjl on 16-9-12.
 */
public interface ApiService {

    String BASE_URL ="http://baobab.wandoujia.com/api/";

//http://baobab.wandoujia.com/api/v3/tabs/selected?
//    udid=3aab4c0bab4d49f4ba4ebc3399f1a5493a38f77b&vc=126&vn=2.4.1&
//    deviceModel=Nexus%205&first_channel=eyepetizer_wandoujia_market&
//    last_channel=eyepetizer_wandoujia_market&system_version_code=21

    // 每日精选
    @GET("v3/tabs/selected")
    Observable<HomeRepo> onHomeDataStore2Api();

}
