package me.racofix.eyes;

import com.android.core.MainApp;
import com.android.core.model.LogicProxy;

import me.racofix.eyes.logic.MainLogicI;

/**
 * Created by zjl on 16-9-12.
 */
public class BaseApp extends MainApp {

    @Override
    public void onCreate() {
        super.onCreate();
        LogicProxy.getInstance().init(MainLogicI.class);
    }
}
