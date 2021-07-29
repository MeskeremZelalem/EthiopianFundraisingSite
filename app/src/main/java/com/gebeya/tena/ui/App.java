package com.gebeya.tena.ui;

import android.app.Application;
import android.util.Log;


import com.gebeya.tena.Const;

import androidx.room.Room;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    //private Retrofit retrofit;
    private UserDatabase db;
    //private NotificationDatabase ndb;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("raper", "<===== ON_CREATE =====>");

        db = Room.databaseBuilder(this,
                UserDatabase.class,
                Const.DATABASE_NAME
        ).allowMainThreadQueries()
                .build();


    }

}
