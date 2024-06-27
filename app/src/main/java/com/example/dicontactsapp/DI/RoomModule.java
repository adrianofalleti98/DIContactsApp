package com.example.dicontactsapp.DI;

import android.app.Application;

import androidx.room.Room;

import com.example.dicontactsapp.DataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    @Provides
    @Singleton
    DataBase providesDatabase(Application app){
        return Room.databaseBuilder(app,DataBase.class,"contacts_db1").allowMainThreadQueries().build();
    }
}
