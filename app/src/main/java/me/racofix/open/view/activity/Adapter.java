package me.racofix.open.view.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.core.manage.image.ImageLoadTool;
import com.android.core.manage.image.ImageLoader;

import java.util.List;

import me.racofix.open.R;
import me.racofix.open.model.Home;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Home.SectionListBean> mDatas;
    private int mViewType;
    private Context mContext;

    public Adapter(Context context, int viewType, List<Home.SectionListBean> mHomeLists) {
        mContext = context;
        mViewType = viewType;
        mDatas = mHomeLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewType == HomeRecylerAdapter.VERTICAL ? new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content_vertical, parent, false)) :
                new ViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_content_horzi, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mViewType == HomeRecylerAdapter.VERTICAL) {
            Home.SectionListBean.ItemListBean bean = mDatas.get(0).getItemList().get(position);
            ImageLoadTool.getInstance().load(mContext, new ImageLoader.Builder()
                    .load(bean.getData().getCover().getDetail())
                    .into(holder.imageView)
                    .placeHolder(R.color.image_place_normal)
                    .build());
            holder.mCategoryView.setText("#" + bean.getData().getCategory());
        } else if (mViewType == HomeRecylerAdapter.HORIZONTAL) {
            Home.SectionListBean.ItemListBean bean1 = mDatas.get(2).getItemList().get(position);
//            if (!TextUtils.isEmpty(bean1.getData().getCover().getFeed())) {
//                ImageLoadTool.getInstance().load(mContext, new ImageLoader.Builder()
//                        .load(bean1.getData().getCover().getFeed())
//                        .into(holder.imageView2)
//                        .placeHolder(R.color.image_place_normal)
//                        .build());
//            }

        }
    }

    @Override
    public int getItemCount() {
        if (mViewType == HomeRecylerAdapter.VERTICAL && mDatas != null && mDatas.size() > 0)
            return mDatas.get(0).getItemList().size();
        else if (mViewType == HomeRecylerAdapter.HORIZONTAL && mDatas != null && mDatas.size() > 0)
            return mDatas.get(2).getItemList().size();
        else
            return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public ImageView imageView2;
        private TextView mCategoryView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_home_img);
            imageView2 = (ImageView) itemView.findViewById(R.id.imageView);
            mCategoryView = (TextView) itemView.findViewById(R.id.tv_category);
        }

    }

}

