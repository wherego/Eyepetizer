package me.racofix.open.view.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.meikoz.core.adapter.RecyclerAdapter;
import com.meikoz.core.adapter.RecyclerViewHolder;
import com.meikoz.core.manage.image.ImageLoadTool;
import com.meikoz.core.manage.image.ImageLoader;

import java.util.List;

import me.racofix.open.R;
import me.racofix.open.model.Discovery;

/**
 * Created by zjl on 16-9-27.
 */

public class DiscoveryAdater extends RecyclerAdapter<Discovery.ItemListBean> {

    public DiscoveryAdater(Context context, int layoutId, List<Discovery.ItemListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(RecyclerViewHolder var1, Discovery.ItemListBean item) {
        ImageLoadTool.getInstance().load(mContext, new ImageLoader.Builder()
                .load(item.getData().getImage())
                .into((ImageView) var1.getView(R.id.iv_disconvery_img))
                .placeHolder(R.color.image_place_normal)
                .build());
        var1.setText(R.id.tv_disconvery_title, item.getData().getTitle());
    }
}
