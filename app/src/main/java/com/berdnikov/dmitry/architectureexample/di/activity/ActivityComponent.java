package com.berdnikov.dmitry.architectureexample.di.activity;

import dagger.Subcomponent;

/**
 * Created by Dmitry on 25.12.2016.
 */

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

}
