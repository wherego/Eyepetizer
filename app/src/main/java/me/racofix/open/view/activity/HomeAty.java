package me.racofix.open.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.racofix.open.R;
import me.racofix.open.api.Api;
import me.racofix.open.model.Home;
import me.racofix.open.view.adapter.HomeRecylerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @User: 蜡笔小新
 * @date: 16-10-14
 * @GitHub: https://github.com/meikoz
 */

public class HomeAty extends Activity {

    private RecyclerView mHomeRecycler;
    private List<Home.SectionListBean> mDatas = new ArrayList<>();
    private HomeRecylerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mHomeRecycler = (RecyclerView) findViewById(R.id.rcv_home_view);
        mHomeRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeRecylerAdapter(this, mDatas);
        mHomeRecycler.setAdapter(mAdapter);
        Api.createApi().onHomeDataStore2Api().enqueue(new Callback<Home>() {
            @Override
            public void onResponse(Call<Home> call, Response<Home> response) {
                Home body = response.body();
                mDatas.addAll(body.getSectionList());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Home> call, Throwable t) {

            }
        });
    }
}
