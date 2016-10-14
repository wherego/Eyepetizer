package me.racofix.open;

import com.android.core.MainApplication;
import com.android.core.manage.log.Logger;

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

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/FZSongKeBenXiuKaiS-R-GB.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
