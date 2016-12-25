package com.berdnikov.dmitry.architectureexample.ui.common.view;

import android.support.annotation.UiThread;

/**
 * Created by Dmitry on 23.12.2016.
 */

public interface MvpLceView<M> extends MvpView {
    @UiThread
    void showLoading(boolean pullToRefresh);

    @UiThread
    void showContent();

    @UiThread
    void showError(Throwable e, boolean pullToRefresh);

    @UiThread
    void setData(M data);

    @UiThread
    void loadData(boolean pullToRefresh);
}
