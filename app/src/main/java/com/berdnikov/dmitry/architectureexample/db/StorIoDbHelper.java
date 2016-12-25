package com.berdnikov.dmitry.architectureexample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

/**
 * Created by Dmitry on 25.12.2016.
 */

public class StorIoDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "arch_sample.db";
    private static final int DATABASE_VERSION = 1;

    public StorIoDbHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}