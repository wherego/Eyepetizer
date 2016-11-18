package me.racofix.open.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.meikoz.core.adapter.RecyclerAdapter;
import com.meikoz.core.adapter.RecyclerViewHolder;

import java.util.List;

import me.racofix.open.R;
import me.racofix.open.model.SectionBean;

/**
 * @User: 蜡笔小新
 * @date: 16-11-18
 * @GitHub: https://github.com/meikoz
 */

public class ItemSectionAdapter extends RecyclerAdapter<SectionBean.ItemListBean> {

    public ItemSectionAdapter(Context context, int layoutId, List<SectionBean.ItemListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(RecyclerViewHolder hepler, SectionBean.ItemListBean bean) {
        hepler.setText(R.id.tv_home_title, bean.getData().getTitle());
//        if (!TextUtils.isEmpty(bean.getData().getCover().getDetail()))
            Glide.with(mContext).load("http://img.kaiyanapp.com/4567faf24c0509b287a9b8d626134095.jpeg?imageMogr2/quality/60")
                    .into((ImageView) hepler.getView(R.id.iv_home_img));
    }
}
