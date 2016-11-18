package me.racofix.open.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.meikoz.core.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.racofix.open.R;
import me.racofix.open.model.Discovery;
import me.racofix.open.presenter.DiscoveryLogicI;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class DiscoveryFragment extends BaseFragment implements DiscoveryLogicI.DiscoveryView {

    @Bind(R.id.category_recyler_view)
    XRecyclerView mCategoryListView;

    List<Discovery.ItemListBean> category_data_list = new ArrayList();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_category;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        mCategoryListView.setLayoutManager(manager);
    }

    @Override
    protected Class getLogicClazz() {
        return DiscoveryLogicI.class;
    }

    @Override
    public void successFul(Discovery body) {
        mCategoryListView.refreshComplete();
        List<Discovery.ItemListBean> list = body.getItemList();
        category_data_list.clear();
        for (int i = 0; i < list.size(); i++) {
            Discovery.ItemListBean adv = list.get(0);
            if (i >= 4) {
                // remove list 4
                category_data_list.add(list.get(i));
            }
        }
    }
}
