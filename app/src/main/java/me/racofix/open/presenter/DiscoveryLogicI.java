package me.racofix.open.presenter;


import com.android.core.base.BaseView;
import com.android.core.model.annotation.Implement;

import me.racofix.open.model.Discovery;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
@Implement(DiscoveryLogicImpl.class)
public interface DiscoveryLogicI {
    void onCategoryDataLayer2Api();

    interface DiscoveryView extends BaseView {
        void successFul(Discovery body);
    }
}
