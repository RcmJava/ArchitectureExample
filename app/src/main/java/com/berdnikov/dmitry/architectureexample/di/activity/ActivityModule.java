package com.berdnikov.dmitry.architectureexample.di.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dmitry on 25.12.2016.
 */

@Module
public abstract class ActivityModule {
    private FragmentActivity activity;

    public ActivityModule(FragmentActivity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope
    protected FragmentActivity activity() {
        return activity;
    }

    @Provides @ActivityScope
    protected FragmentManager fragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides @ActivityScope
    protected LayoutInflater layoutInflater() {
        return activity.getLayoutInflater();
    }
}
