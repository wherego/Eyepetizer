package me.racofix.eyes.presenter;

import com.android.core.api.TransformUtils;
import com.android.core.base.rx.ApiCallback;
import com.android.core.base.rx.RxSubscriber;
import com.android.core.base.rx.SubscriberCallBack;
import com.android.core.presenter.DataLayerLogicImpl;

import me.racofix.eyes.api.Api;
import me.racofix.eyes.model.HomeRepo;
import rx.Subscription;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class HomeLogicImpl extends DataLayerLogicImpl<HomeRepo> implements HomeLogicI {

    @Override
    public void onHomeDataLayer2Api() {
        getView().showProgress("正在加载");
        addSubscription(
                Api.createApi().onHomeDataStore2Api(), new SubscriberCallBack<>(new ApiCallback<HomeRepo>() {
           @Override
           public void onSuccess(HomeRepo repo) {
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
