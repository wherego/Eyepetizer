package me.racofix.open;

import com.android.core.MainApp;
import com.android.core.control.logcat.Logcat;
import com.android.core.presenter.LogicProxy;

import me.racofix.open.presenter.HomeLogicI;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by zjl on 16-9-12.
 */
public class BaseApp extends MainApp {

    @Override
    public void onCreate() {
        super.onCreate();

        LogicProxy.getInstance().init(HomeLogicI.class);

        if (BuildConfig.DEBUG)
            Logcat.init(getPackageName()).hideThreadInfo().methodCount(3);

//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/Nunito-Bold.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );
    }
}
