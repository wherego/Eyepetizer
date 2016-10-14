package me.racofix.open.presenter;


import com.android.core.base.BaseView;
import com.android.core.model.annotation.Implement;

import me.racofix.open.model.Home;
import retrofit2.Response;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
@Implement(HomeLogicImpl.class)
public interface HomeLogicI {
    void onHomeDataLayer2Api();

    interface HomeView extends BaseView {
        void success(Home body);
    }
}
