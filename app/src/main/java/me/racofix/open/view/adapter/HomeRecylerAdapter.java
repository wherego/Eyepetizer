package me.racofix.open.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meikoz.core.manage.ScreenUtil;

import java.util.List;

import me.racofix.open.R;
import me.racofix.open.model.SectionBean;

/**
 * @User: 蜡笔小新
 * @date: 16-10-14
 * @GitHub: https://github.com/meikoz
 */

public class HomeRecylerAdapter extends RecyclerView.Adapter<HomeRecylerAdapter.ViewHolder> {

    private List<SectionBean> mSectionList;
    private Context mContext;

    public HomeRecylerAdapter(Context context, List<SectionBean> sectionList) {
        this.mContext = context;
        this.mSectionList = sectionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List<SectionBean.ItemListBean> itemList = mSectionList.get(position).getItemList();
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        ItemSectionAdapter adapter = new ItemSectionAdapter(mContext,
                R.layout.item_content_home,
                itemList);
        holder.onMeasureChildHeight(mContext, itemList.size(), manager, adapter);
        holder.mFootView.setText(mSectionList.get(position).getFooter().getType());
    }

    @Override
    public int getItemCount() {
        return mSectionList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mItemListView;
        private final TextView mFootView;

        ViewHolder(View rootView) {
            super(rootView);
            mItemListView = (RecyclerView) itemView.findViewById(R.id.itemView);
            mFootView = (TextView) itemView.findViewById(R.id.footView);
        }

        public void onMeasureChildHeight(Context ctx, int size, LinearLayoutManager manager, ItemSectionAdapter adapter) {
            ViewGroup.LayoutParams layoutParams = mItemListView.getLayoutParams();
            //高度等于＝条目的高度＋ 10dp的间距 ＋ 10dp（为了让条目居中）
            layoutParams.height = ScreenUtil.dp2px(ctx, 200) * size;
            mItemListView.setLayoutParams(layoutParams);
            mItemListView.setLayoutManager(manager);
            mItemListView.setAdapter(adapter);
        }
    }
}
