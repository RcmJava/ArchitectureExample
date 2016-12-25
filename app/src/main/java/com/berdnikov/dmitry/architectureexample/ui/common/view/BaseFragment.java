package com.berdnikov.dmitry.architectureexample.ui.common.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dmitry on 23.12.2016.
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    protected T binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        doInjections(savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        binding.unbind();
        super.onDestroyView();
    }

    /*
    * Метод для выполнения DI
    */
    protected abstract void doInjections(@Nullable Bundle savedInstanceState);

    /*
    * Метод возвращает layout id, применяемый к Activity
    */
    @LayoutRes
    protected abstract int getLayoutRes();
}
