package com.example.neslaram.androidchat;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by neslaram on 19/06/16.
 */
public class AndroidChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
