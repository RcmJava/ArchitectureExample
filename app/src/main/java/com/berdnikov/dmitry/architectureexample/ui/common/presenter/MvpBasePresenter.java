package com.berdnikov.dmitry.architectureexample.ui.common.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;

import com.berdnikov.dmitry.architectureexample.ui.common.view.MvpView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Dmitry on 23.12.2016.
 */

public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {
    @NonNull
    private final CompositeSubscription subscriptionsToUnsubscribeOnUnbindView = new CompositeSubscription();

    private volatile V viewRef;

    @UiThread
    @Override public void bindView(V view) {
        viewRef = view;
    }

    @UiThread
    @Override public void unbindView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef = null;
        }
        subscriptionsToUnsubscribeOnUnbindView.clear();
    }

    /**
     * Получает присоедененную вью.
     * @return <code>null</code>, if view is not attached, otherwise the concrete view instance
     */
    @UiThread
    protected V getView() {
        return viewRef;
    }

    /**
     * Проверяет, что вью присоеденена к презентеру. Нужно вызывать всегда перед вызовом
     * {@link #getView()}.
     */
    @UiThread
    protected boolean isViewAttached() {
        return viewRef != null;
    }

    protected final void unsubscribeOnUnbindView(@NonNull Subscription subscription, @NonNull Subscription... subscriptions) {
        subscriptionsToUnsubscribeOnUnbindView.add(subscription);

        for (Subscription s : subscriptions) {
            subscriptionsToUnsubscribeOnUnbindView.add(s);
        }
    }
}
