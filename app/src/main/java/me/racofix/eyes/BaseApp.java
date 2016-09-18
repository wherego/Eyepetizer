package me.racofix.eyes;

import com.android.core.MainApp;
import com.android.core.control.logcat.Logcat;
import com.android.core.presenter.LogicProxy;

import me.racofix.eyes.presenter.HomeLogicI;

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
    }
}
