package com.berdnikov.dmitry.architectureexample.di.app;

import com.berdnikov.dmitry.architectureexample.BaseContext;
import com.berdnikov.dmitry.architectureexample.di.activity.ActivityComponent;
import com.berdnikov.dmitry.architectureexample.di.activity.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Dmitry on 23.12.2016.
 */

@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {
    BaseContext inject(BaseContext application);
    ActivityComponent plusActivityComponent(ActivityModule module);
}
