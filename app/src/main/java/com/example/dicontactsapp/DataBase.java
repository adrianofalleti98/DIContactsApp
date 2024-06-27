package com.example.dicontactsapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = Contacts.class,version = 6)
public abstract class DataBase extends RoomDatabase {
    public abstract ContactsDao getContactsDao();

    //Singleton pattern
    private static DataBase db;
    public static synchronized DataBase getInstance(Context context){
        if (db == null){
            db = Room.databaseBuilder(context.getApplicationContext(), DataBase.class,"contacts_db1").fallbackToDestructiveMigration().build();
        }
        return db;
    }
}
