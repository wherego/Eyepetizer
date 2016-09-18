package me.racofix.eyes.api;

import com.android.core.api.RestApi;
import me.racofix.eyes.BuildConfig;

/**
 * Created by zjl on 16-9-12.
 */
public class Api {

    // create service single
    public static ApiService createApi() {
        return RestApi.getIns().createService( BuildConfig.DEBUG, ApiService.class);
    }
}
