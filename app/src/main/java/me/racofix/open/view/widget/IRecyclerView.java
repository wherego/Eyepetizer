package me.racofix.open.view.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.android.core.control.logcat.Logcat;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.racofix.open.R;

/**
 * Created by zjl on 16-9-26.
 */

public class IRecyclerView extends FrameLayout implements
        SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

    private Context mContext;
    private View mView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private IRecyclerViewListener mRefreshListener;
    private boolean hasMore = true;
    private int lastVisibleItem;

    @Override
    public final void onRefresh() {
        if (mRefreshListener != null) {
            mRefreshListener.onRefresh();
        }
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
    }

    private void createRecyclerView(Context context) {
        mView = LayoutInflater.from(context).inflate(R.layout.view_recycler, this);
        ButterKnife.bind(this);
        if (mView == null) {
            Logcat.e("mView is null, it is a fastandroiddev error, please contact developer.");
            return;
        }

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mSwipeRefresh.setOnRefreshListener(this);

        // 这句话是为了，第一次进入页面的时候显示加载进度条
        mSwipeRefresh.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
    }


    public void setAdapter(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
        addListener();
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public void setIRecyclerViewListener(IRecyclerViewListener mRefreshListener) {
        this.mRefreshListener = mRefreshListener;
    }

    private void addListener() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mRecyclerView == null || newState != RecyclerView.SCROLL_STATE_IDLE) {
                    return;
                }

                if (lastVisibleItem + 1 == mAdapter.getItemCount() && hasMore) {
                    mRefreshListener.onLoadMore();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 初始化入口
     *
     * @param context context
     * @param attrs   参数
     */
    private void doInit(Context context, AttributeSet attrs) {
        this.mContext = context;
        createRecyclerView(context);
    }

    public IRecyclerView(Context context) {
        super(context);
        doInit(context, null);
    }

    public IRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        doInit(context, attrs);
    }

    public IRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        doInit(context, attrs);
    }

    public interface IRecyclerViewListener {
        void onLoadMore();

        void onRefresh();
    }
}
