package me.racofix.open.presenter;

import com.android.core.base.BasePresenter;
import com.android.core.base.rx.ApiCallback;
import com.android.core.base.rx.SubscriberCallBack;

import me.racofix.open.api.Api;
import me.racofix.open.model.Discovery;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class DiscoveryLogicImpl extends BasePresenter<DiscoveryLogicI.DiscoveryView> implements DiscoveryLogicI {

    @Override
    public void onCategoryDataLayer2Api() {
        Api.createApi().onCategoryData2Api().enqueue(new Callback<Discovery>() {
            @Override
            public void onResponse(Call<Discovery> call, Response<Discovery> response) {
                getView().successFul(response.body());
            }

            @Override
            public void onFailure(Call<Discovery> call, Throwable t) {

            }
        });
    }
}
