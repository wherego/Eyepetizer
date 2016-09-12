package me.racofix.eyes.view.fragment;

import com.android.core.base.AbsBaseFragment;
import com.android.core.base.BaseView;

import me.racofix.eyes.R;
import me.racofix.eyes.logic.MainLogicI;
import me.racofix.eyes.logic.MainLogicIpml;

/**
 * Created by zjl on 16-9-12.
 */
public class HomeFragment extends AbsBaseFragment implements BaseView {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView() {
        MainLogicIpml mMain = getLogicImpl(MainLogicI.class, this);
        mMain.onRecviceHomeData2Api(2);
    }
}
