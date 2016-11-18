package me.racofix.open.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.racofix.open.R;
import me.racofix.open.model.Home;

/**
 * @User: 蜡笔小新
 * @date: 16-10-14
 * @GitHub: https://github.com/meikoz
 */

public class HomeRecylerAdapter extends RecyclerView.Adapter<HomeRecylerAdapter.ViewHolder> {

    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 2;
    private List<Home.SectionListBean> mHomeLists;
    private Context mContext;

    public HomeRecylerAdapter(Context context, List<Home.SectionListBean> mHomeLists) {
        this.mContext = context;
        this.mHomeLists = mHomeLists;
    }

    @Override
    public int getItemViewType(int position) {
        return position == VERTICAL ? VERTICAL : HORIZONTAL;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == VERTICAL) {
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
                    .recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        } else if (position == HORIZONTAL){
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
                    .recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        }
        holder.recyclerView.setAdapter(new Adapter(mContext, position, mHomeLists));
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView recyclerView;

        public ViewHolder(View rootView) {
            super(rootView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}
