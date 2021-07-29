package com.gebeya.tena.ui;

import com.gebeya.tena.User;
import com.gebeya.tena.ui.UserDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}