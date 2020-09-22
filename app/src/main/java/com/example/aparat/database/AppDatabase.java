package com.example.aparat.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aparat.model.Videos;

@Database(entities = {Videos.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DAO getDAO();

    private static AppDatabase instance = null;

    public static synchronized AppDatabase getInstance (Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "Aparat").allowMainThreadQueries().build();
        }

        return instance;
    }

}
