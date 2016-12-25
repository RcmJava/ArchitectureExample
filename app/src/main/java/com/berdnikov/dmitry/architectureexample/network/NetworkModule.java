package com.berdnikov.dmitry.architectureexample.network;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Dmitry on 23.12.2016.
 */

@Module
public class NetworkModule {
    @Provides @NonNull @Singleton
    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        return okHttpBuilder.build();
    }

    @Provides @NonNull @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                //.registerTypeAdapterFactory(typeAdapterFactory)
                .create();
    }
}
