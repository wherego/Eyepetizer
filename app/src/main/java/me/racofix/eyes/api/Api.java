package me.racofix.eyes.api;

import com.android.core.api.HttpClient;

/**
 * Created by zjl on 16-9-12.
 */
public class Api {

    // create service single
    public static ApiService createApiService() {
        return HttpClient.getIns(Constant.API_BASE_URL).createService(ApiService.class);
    }
}
