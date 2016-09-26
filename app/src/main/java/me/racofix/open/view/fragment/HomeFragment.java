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
import com.android.core.widget.glide.ImageLoader;
import com.android.core.widget.glide.ImageLoaderUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.racofix.open.R;
import me.racofix.open.model.SelectedRepo;
import me.racofix.open.presenter.HomeLogicI;
import me.racofix.open.presenter.HomeLogicImpl;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class HomeFragment extends BaseFragment implements RxView<SelectedRepo> {

    @Bind(R.id.recycler_view_home)
    XRecyclerView mRecylerView;
    private List<SelectedRepo.SectionListBean.ItemListBean> home_list = new ArrayList();
    private RecyclerAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView() {
        mPresenter = getLogicImpl(HomeLogicI.class, this);
        ((HomeLogicImpl) mPresenter).onHomeDataLayer2Api();

        adapter = new RecyclerAdapter<SelectedRepo.SectionListBean.ItemListBean>(getActivity(), R.layout.item_content_home, home_list) {
            @Override
            public void convert(RecyclerViewHolder holder, SelectedRepo.SectionListBean.ItemListBean repo) {
                holder.setText(R.id.tv_home_title, repo.getData().getTitle());
                int duration = repo.getData().getDuration();
                int mm = duration / 60;//分
                int ss = duration % 60;//秒
                String second = "";//秒
                String minute = "";//分
                if (ss < 10) {
                    second = "0" + String.valueOf(ss);
                } else {
                    second = String.valueOf(ss);
                }
                if (mm < 10) {
                    minute = "0" + String.valueOf(mm);
                } else {
                    minute = String.valueOf(mm);//分钟
                }
                holder.setText(R.id.tv_category, "#"+repo.getData().getCategory()+"  /  "  + minute + "' " + second + '"');
                ImageLoaderUtil.getInstance().loadImage(getActivity(), new ImageLoader.Builder()
                        .url(repo.getData().getCover().getDetail())
                        .imgView((ImageView) holder.getView(R.id.iv_home_img))
                        .placeHolder(R.color.image_place_normal)
                        .build());
            }
        };
        mRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecylerView.setAdapter(adapter);
    }

    @Override
    public void onReceiveData2Api(SelectedRepo repo, boolean b) {
        List<SelectedRepo.SectionListBean.ItemListBean> sectionList = repo.getSectionList().get(0).getItemList();
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
