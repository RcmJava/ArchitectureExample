package com.berdnikov.dmitry.architectureexample;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.berdnikov.dmitry.architectureexample.di.app.AppComponent;
import com.berdnikov.dmitry.architectureexample.di.app.AppModule;
import com.berdnikov.dmitry.architectureexample.di.app.DaggerAppComponent;

/**
 * Created by Dmitry on 23.12.2016.
 */

public class BaseContext extends Application {
    private AppComponent appComponent;

    @NonNull
    public static BaseContext get(@NonNull Context context) {
        return (BaseContext) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

}
