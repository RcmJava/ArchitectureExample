package com.berdnikov.dmitry.architectureexample.ui.lce.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.berdnikov.dmitry.architectureexample.R;
import com.berdnikov.dmitry.architectureexample.databinding.FragmentLceBinding;
import com.berdnikov.dmitry.architectureexample.ui.common.view.BaseFragment;

/**
 * Created by Dmitry on 25.12.2016.
 */

public abstract class BaseLceFragment<M> extends BaseFragment<FragmentLceBinding>
        implements MvpLceView<M> {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_lce;
    }

    @CallSuper
    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.includedError.errorView.setOnClickListener(v -> onErrorViewClicked());
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        if (!pullToRefresh) {
            animateLoadingViewIn();
        }
    }

    /**
     * Можно переопределить этот метод, если нужна другая анимация
     */
    protected void animateLoadingViewIn() {
        LceAnimator.showLoading(binding.includedLoading.loadingView, binding.contentView, binding.includedError.errorView);
    }

    @Override
    public void showContent() {
        animateContentViewIn();
    }

    /**
     * Переключается загрузочный экран в экран с данными
     */
    protected void animateContentViewIn() {
        LceAnimator.showContent(binding.includedLoading.loadingView, binding.contentView, binding.includedError.errorView);
    }

    /**
     * Извлекаем сообщение-ошибку из исключения для {@link
     * #showError(Throwable, boolean)}
     */
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        if (pullToRefresh) {
            return "An error has occurred!";
        } else {
            return "An error has occurred. Click here to retry";
        }
    }

    /**
     * По умолчанию показывает toast-сообщение (i.e. pull-to-refresh
     * error).
     * Переопределить этот метод можно, чтобы по другому показать сообщение.
     */
    protected void showLightError(String msg) {
        if (getActivity() != null) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Called if the error view has been clicked. To disable clicking on the errorView use
     * <code>errorView.setClickable(false)</code>
     */
    protected void onErrorViewClicked() {
        loadData(false);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        String errorMsg = getErrorMessage(e, pullToRefresh);

        if (pullToRefresh) {
            showLightError(errorMsg);
        } else {
            binding.includedError.errorView.setText(errorMsg);
            animateErrorViewIn();
        }
    }

    protected void animateErrorViewIn() {
        LceAnimator.showErrorView(binding.includedLoading.loadingView, binding.contentView, binding.includedError.errorView);
    }

    @Override
    public void onDestroyView() {
        binding.includedError.errorView.setOnClickListener(null);
        super.onDestroyView();
    }
}