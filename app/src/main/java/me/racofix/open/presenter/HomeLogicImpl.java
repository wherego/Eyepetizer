package me.racofix.open.presenter;

import com.android.core.base.rx.ApiCallback;
import com.android.core.base.rx.SubscriberCallBack;
import com.android.core.presenter.DataLayerLogicImpl;

import me.racofix.open.api.Api;
import me.racofix.open.model.SelectedRepo;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class HomeLogicImpl extends DataLayerLogicImpl<SelectedRepo> implements HomeLogicI {

    @Override
    public void onHomeDataLayer2Api() {
        getView().showProgress("正在加载");
        addSubscription(
                Api.createApi().onHomeDataStore2Api(), new SubscriberCallBack<>(new ApiCallback<SelectedRepo>() {
           @Override
           public void onSuccess(SelectedRepo repo) {
               onDataStore2View(repo);
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
