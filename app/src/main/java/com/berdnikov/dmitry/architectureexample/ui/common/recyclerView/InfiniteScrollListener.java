package com.berdnikov.dmitry.architectureexample.ui.common.recyclerView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by Dmitry on 25.12.2016.
 */

public abstract class InfiniteScrollListener extends RecyclerView.OnScrollListener {
    private int previousTotal = 0;
    private boolean loading = false;
    private boolean canLoadMore = true;
    private final int visibleThreshold = 0;
    private int firstVisibleItem;
    private int visibleItemCount;
    private int totalItemCount;
    private int currentPage = 0;
    private LinearLayoutManager linearLayoutManager;
    private Runnable loadMore = () -> onLoadMore(currentPage);

    public InfiniteScrollListener(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(final RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = linearLayoutManager.getItemCount();
        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

        if (loading) {
            if (totalItemCount > previousTotal || totalItemCount == 0) {
                previousTotal = totalItemCount;
            }
        }

        if (canLoadMore && !loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            currentPage++;
            Log.d("PAGING", "Current page " + currentPage + " - loading = " + loading);
            recyclerView.post(loadMore);

        }
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public void setCanLoadMore(boolean canLoadMore) {
        this.canLoadMore = canLoadMore;
    }

    public abstract void onLoadMore(int current_page);
}