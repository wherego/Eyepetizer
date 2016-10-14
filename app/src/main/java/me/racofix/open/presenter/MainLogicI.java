package me.racofix.open.presenter;

import com.android.core.model.annotation.Implement;

/**
 * Created by zjl on 16-9-12.
 */
@Implement(MainLogicIpml.class)
interface MainLogicI {
    void onRecviceHomeData2Api(int num);
}
