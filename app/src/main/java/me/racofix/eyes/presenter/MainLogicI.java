package me.racofix.eyes.presenter;

import com.android.core.presenter.annotation.Implement;

/**
 * Created by zjl on 16-9-12.
 */
@Implement(MainLogicIpml.class)
public interface MainLogicI {

    void onRecviceHomeData2Api(int num);
}
