package me.racofix.eyes.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.core.adapter.RecyclerAdapter;
import com.android.core.adapter.RecyclerViewHolder;
import com.android.core.base.BaseFragment;
import com.android.core.base.rx.RxView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.racofix.eyes.R;
import me.racofix.eyes.model.HomeRepo;
import me.racofix.eyes.presenter.HomeLogicI;
import me.racofix.eyes.presenter.HomeLogicImpl;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class HomeFragment extends BaseFragment implements RxView<HomeRepo> {

    @Bind(R.id.recycler_view_home) XRecyclerView mRecylerView;
    private List<HomeRepo.SectionListBean> home_list = new ArrayList();
    private RecyclerAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView() {
        mPresenter = getLogicImpl(HomeLogicI.class, this);
        ((HomeLogicImpl) mPresenter).onHomeDataLayer2Api();

        adapter = new RecyclerAdapter<HomeRepo.SectionListBean>(getActivity(), R.layout.item_content_home, home_list) {
            @Override
            public void convert(RecyclerViewHolder holder, HomeRepo.SectionListBean repo) {
                holder.setText(R.id.tv_home_title,repo.getItemList().get(0).getData().getTitle());
            }
        };
        mRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecylerView.setAdapter(adapter);
    }

    @Override
    public void onReceiveData2Api(HomeRepo repo, boolean b) {
        List<HomeRepo.SectionListBean> sectionList = repo.getSectionList();
        home_list.addAll(sectionList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
