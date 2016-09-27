package me.racofix.open.presenter;

import com.android.core.base.rx.ApiCallback;
import com.android.core.base.rx.SubscriberCallBack;
import com.android.core.presenter.DataLayerLogicImpl;

import me.racofix.open.api.Api;
import me.racofix.open.model.Discovery;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class DiscoveryLogicImpl extends DataLayerLogicImpl<Discovery> implements DiscoveryLogicI {

    @Override
    public void onCategoryDataLayer2Api() {
        addSubscription(
                Api.createApi().onCategoryData2Api(), new SubscriberCallBack<>(new ApiCallback<Discovery>() {
                    @Override
                    public void onSuccess(Discovery response) {
                        onDataStore2View(response);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        getView().showErrorMessage(s,s);
                    }

                    @Override
                    public void onCompleted() {
                        getView().hideProgress();
                    }
                }));
    }
}
