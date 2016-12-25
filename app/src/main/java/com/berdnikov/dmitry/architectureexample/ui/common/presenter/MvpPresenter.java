package com.berdnikov.dmitry.architectureexample.ui.common.presenter;

import android.support.annotation.UiThread;

import com.berdnikov.dmitry.architectureexample.ui.common.view.MvpView;

/**
 * Created by Dmitry on 23.12.2016.
 */

public interface MvpPresenter<V extends MvpView> {
    /**
     * Связывает вью с презентером
     */
    @UiThread
    void bindView(V view);

    /**
     * Вызывается когда представление уничтожается, вызывается из
     * <code>Activity.detachView()</code> или <code>Fragment.onDestroyView()</code>
     */
    @UiThread
    void unbindView(boolean retainInstance);
}
