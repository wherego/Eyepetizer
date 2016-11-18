package me.racofix.open.presenter;

import com.meikoz.core.base.BasePresenter;

import me.racofix.open.api.Api;
import me.racofix.open.model.Home;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class HomeLogicImpl extends BasePresenter<HomeLogicI.HomeView> implements HomeLogicI {

    @Override
    public void onHomeDataLayer2Api() {
        Api.createApi().onHomeDataStore2Api().enqueue(new Callback<Home>() {
            @Override
            public void onResponse(Call<Home> call, Response<Home> response) {
                getView().success(response.body());
            }

            @Override
            public void onFailure(Call<Home> call, Throwable t) {

            }
        });
    }
}
