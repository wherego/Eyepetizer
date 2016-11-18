package me.racofix.open.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.meikoz.core.adapter.RecyclerAdapter;
import com.meikoz.core.adapter.RecyclerViewHolder;
import com.meikoz.core.base.BaseFragment;
import com.meikoz.core.manage.image.ImageLoadTool;
import com.meikoz.core.manage.image.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.racofix.open.R;
import me.racofix.open.model.Home;
import me.racofix.open.presenter.HomeLogicI;
import me.racofix.open.presenter.HomeLogicImpl;

/**
 * Author: 码农小阿新
 * Date: 2016/9/18
 * Github: https://github.com/racofix
 */
public class HomeFragment extends BaseFragment implements HomeLogicI.HomeView {

    @Bind(R.id.recycler_view_home)
    XRecyclerView mRecylerView;
    private List<Home.SectionListBean.ItemListBean> home_list = new ArrayList();
    private RecyclerAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitData2Api() {
        super.onInitData2Api();
        ((HomeLogicImpl) mPresenter).onHomeDataLayer2Api();
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        adapter = new RecyclerAdapter<Home.SectionListBean.ItemListBean>(getActivity(), R.layout.item_content_home, home_list) {
            @Override
            public void convert(RecyclerViewHolder holder, Home.SectionListBean.ItemListBean repo) {
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
                holder.setText(R.id.tv_category, "#" + repo.getData().getCategory() + "  /  " + minute + "' " + second + '"');
//                ImageLoadTool.getInstance().load(getActivity(), new ImageLoader.Builder()
//                        .load(repo.getData().getCover().getDetail())
//                        .into((ImageView) holder.getView(R.id.iv_home_img))
//                        .placeHolder(R.color.image_place_normal)
//                        .build());
            }
        };
        mRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecylerView.setAdapter(adapter);
    }

    @Override
    protected Class getLogicClazz() {
        return HomeLogicI.class;
    }

    @Override
    public void success(Home body) {
        List<Home.SectionListBean> list1 = body.getSectionList();
        List<Home.SectionListBean.ItemListBean> list = body.getSectionList().get(0).getItemList();
        home_list.addAll(list);
        adapter.notifyDataSetChanged();
    }
}
