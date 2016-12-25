package com.berdnikov.dmitry.architectureexample.ui.common.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 23.12.2016.
 */

public abstract class AbsDelegationAdapter<T> extends RecyclerView.Adapter {
    protected AdapterDelegatesManager<T> delegatesManager;
    protected List<T> items = new ArrayList<>();

    public AbsDelegationAdapter() {
        this(new AdapterDelegatesManager<T>());
    }

    public AbsDelegationAdapter(@NonNull AdapterDelegatesManager<T> delegatesManager) {
        if (delegatesManager == null) {
            throw new NullPointerException("AdapterDelegatesManager is null");
        }

        this.delegatesManager = delegatesManager;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder, null);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        delegatesManager.onBindViewHolder(items, position, holder, payloads);
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(items, position);
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        delegatesManager.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder holder) {
        return delegatesManager.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        delegatesManager.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        delegatesManager.onViewDetachedFromWindow(holder);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public T getItem(int position) {
        return items.get(position);
    }

    public void add(int position, T item) {
        items.add(position, item);
        notifyItemInserted(position);
        int positionStart = position;
        int itemCount = items.size() - position;
        notifyItemRangeChanged(positionStart, itemCount);
    }

    public void add(T item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void addAll(List<? extends T> items) {
        final int size = this.items.size();
        this.items.addAll(items);
        notifyItemRangeInserted(size, items.size());
    }

    public void addAll(int position, List<? extends T> items) {
        this.items.addAll(position, items);
        notifyItemRangeInserted(position, items.size());
    }

    public void set(int position, T item) {
        items.set(position, item);
        notifyItemChanged(position);
    }

    public void removeChild(int position) {
        items.remove(position);
        notifyItemRemoved(position);
        /*int positionStart = position;
        int itemCount = items.size() - position;
        notifyItemRangeChanged(positionStart, itemCount);*/
    }

    public void clear() {
        final int size = items.size();
        items.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void clearRange(int startPosition) {
        final int size = items.size();
        items.subList(startPosition, size).clear();
        notifyItemRangeRemoved(startPosition, size);
    }

    public int indexOf(T object) {
        return items.indexOf(object);
    }
}