package me.racofix.open.view.fragment;

import android.support.v7.widget.GridLayoutManager;

import com.android.core.adapter.RecyclerAdapter;
import com.android.core.base.BaseFragment;
import com.android.core.base.rx.RxView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.racofix.open.R;
import me.racofix.open.model.Discovery;
import me.racofix.open.presenter.DiscoveryLogicI;
import me.racofix.open.presenter.DiscoveryLogicImpl;
import me.racofix.open.view.adapter.DiscoveryAdater;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class DiscoveryFragment extends BaseFragment implements RxView<Discovery>, XRecyclerView.LoadingListener {

    @Bind(R.id.category_recyler_view)
    XRecyclerView mCategoryListView;

    List<Discovery.ItemListBean> category_data_list = new ArrayList();
    private RecyclerAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_category;
    }

    @Override
    protected void onInitView() {

        mPresenter = getLogicImpl(DiscoveryLogicI.class, this);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        mCategoryListView.setLayoutManager(manager);
        mCategoryListView.setRefreshProgressStyle(22);
//        mCategoryListView.setLoadingMoreProgressStyle(7);
        mCategoryListView.setArrowImageView(com.android.core.R.drawable.abc_icon_down_arrow);
        mCategoryListView.setLoadingListener(this);
        mCategoryListView.setLoadingMoreEnabled(false);

        mAdapter = new DiscoveryAdater(getActivity(), R.layout.item_content_discovery, category_data_list);
        mCategoryListView.setAdapter(mAdapter);

        onRefresh();
    }

    @Override
    public void onReceiveData2Api(Discovery category, boolean b) {
        mCategoryListView.refreshComplete();
        List<Discovery.ItemListBean> list = category.getItemList();
        category_data_list.clear();
        for (int i = 0; i < list.size(); i++) {
            Discovery.ItemListBean adv = list.get(0);
            if (i >= 4) {
                // remove list 4
                category_data_list.add(list.get(i));
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        ((DiscoveryLogicImpl) mPresenter).onCategoryDataLayer2Api();
    }

    @Override
    public void onLoadMore() {

    }
}
