package com.berdnikov.dmitry.architectureexample.model;

import android.support.annotation.NonNull;

import com.berdnikov.dmitry.architectureexample.network.Api;

/**
 * Created by Dmitry on 24.12.2016.
 */

public class RepositoryImpl implements Repository {
    @NonNull private final Api api;

    public RepositoryImpl(@NonNull Api api) {
        this.api = api;
    }
}
