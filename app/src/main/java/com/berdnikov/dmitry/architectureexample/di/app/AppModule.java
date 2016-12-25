package com.berdnikov.dmitry.architectureexample.di.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.berdnikov.dmitry.architectureexample.model.Repository;
import com.berdnikov.dmitry.architectureexample.model.RepositoryImpl;
import com.berdnikov.dmitry.architectureexample.network.Api;
import com.f2prateek.rx.preferences.RxSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dmitry on 23.12.2016.
 */

@Module
public class AppModule {
    @NonNull
    private final Application application;

    public AppModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides @NonNull @Singleton
    public Repository provideRepository(@NonNull Api api) {
        return new RepositoryImpl(api);
    }
}
