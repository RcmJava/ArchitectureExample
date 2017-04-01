package com.berdnikov.dmitry.architectureexample.network;

import android.support.annotation.NonNull;

import com.berdnikov.dmitry.architectureexample.BuildConfig;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dmitry on 23.12.2016.
 */

@Module
public class ApiModule {
    private static final String BASE_URL = "http://test.ru/";

    @Provides @NonNull
    @Singleton
    public Api provideApi(@NonNull OkHttpClient okHttpClient, @NonNull Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .validateEagerly(BuildConfig.DEBUG)
                .build()
                .create(Api.class);
    }
}
