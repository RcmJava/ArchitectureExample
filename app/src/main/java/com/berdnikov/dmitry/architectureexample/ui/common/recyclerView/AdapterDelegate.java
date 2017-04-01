package com.berdnikov.dmitry.architectureexample.ui.common.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Dmitry on 23.12.2016.
 */

public abstract class AdapterDelegate<T> {

    protected abstract boolean isForViewType(@NonNull List<T> items, int position);

    @NonNull
    abstract protected RecyclerView.ViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup parent);

    protected abstract void onBindViewHolder(@NonNull List<T> items,
                                             int position,
                                             @NonNull RecyclerView.ViewHolder holder,
                                             @NonNull List<Object> payloads);

    protected void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    protected boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder holder) {
        return false;
    }

    protected void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
    }

    protected void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
    }
}
