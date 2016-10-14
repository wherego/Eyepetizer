package me.racofix.open.api;

import com.android.core.api.RestApi;
import me.racofix.open.BuildConfig;

/**
 * Created by zjl on 16-9-12.
 */
public class Api {

    // create service single
    public static ApiService createApi() {
        return RestApi.getIns().createService(BuildConfig.DEBUG, ApiService.class);
    }
}
