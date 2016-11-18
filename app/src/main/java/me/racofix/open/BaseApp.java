package me.racofix.open;

import com.meikoz.core.MainApplication;
import com.meikoz.core.api.RestApi;
import com.meikoz.core.manage.log.Logger;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by zjl on 16-9-12.
 */
public class BaseApp extends MainApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG)
            Logger.init(getPackageName()).hideThreadInfo().methodCount(3);
        RestApi.getInstance().init(true);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/FZSongKeBenXiuKaiS-R-GB.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
