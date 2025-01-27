package com.example.reminderapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        //membuat realm aktif pada alpikasi
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .name("ReminderApp")
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

}
