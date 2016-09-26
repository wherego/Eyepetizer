package me.racofix.open.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.core.adapter.RecyclerAdapter;
import com.android.core.adapter.RecyclerViewHolder;
import com.android.core.base.BaseFragment;
import com.android.core.base.rx.RxView;
import com.android.core.control.ToastUtil;
import com.android.core.widget.glide.ImageLoader;
import com.android.core.widget.glide.ImageLoaderUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.racofix.open.R;
import me.racofix.open.model.HomeRepo;
import me.racofix.open.presenter.HomeLogicI;
import me.racofix.open.presenter.HomeLogicImpl;
import me.racofix.open.view.widget.IRecyclerView;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class CategoryFragment extends BaseFragment implements RxView<HomeRepo>, IRecyclerView.IRecyclerViewListener {

    @Bind(R.id.category_recyler_view)
    IRecyclerView mRecylerView;
    private List<HomeRepo.SectionListBean.ItemListBean> home_list = new ArrayList();
    private RecyclerAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_category;
    }

    @Override
    protected void onInitView() {
        mPresenter = getLogicImpl(HomeLogicI.class, this);
        ((HomeLogicImpl) mPresenter).onHomeDataLayer2Api();

        adapter = new RecyclerAdapter<HomeRepo.SectionListBean.ItemListBean>(getActivity(), R.layout.item_content_home, home_list) {
            @Override
            public void convert(RecyclerViewHolder holder, HomeRepo.SectionListBean.ItemListBean repo) {
                holder.setText(R.id.tv_home_title, repo.getData().getTitle());

                ImageLoaderUtil.getInstance().loadImage(getActivity(), new ImageLoader.Builder()
                        .url(repo.getData().getCover().getDetail())
                        .imgView((ImageView) holder.getView(R.id.iv_home_img))
                        .placeHolder(R.color.image_place_normal)
                        .build());
            }
        };
        mRecylerView.setHasMore(true);
        mRecylerView.setAdapter(adapter);
        mRecylerView.setIRecyclerViewListener(this);
    }

    @Override
    public void onReceiveData2Api(HomeRepo repo, boolean b) {
        List<HomeRepo.SectionListBean.ItemListBean> sectionList = repo.getSectionList().get(0).getItemList();
        home_list.addAll(sectionList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore() {
        ToastUtil.show("加载更多");
    }

    @Override
    public void onRefresh() {
        ToastUtil.show("刷新");
    }
}
