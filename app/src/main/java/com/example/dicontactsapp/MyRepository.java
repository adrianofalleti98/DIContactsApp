package com.example.dicontactsapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.app.AppLaunchChecker;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRepository {
    private final ContactsDao dao;
    private ExecutorService executorService;
    private Handler handler;
    public MyRepository(Application app) {
        DataBase db = DataBase.getInstance(app.getApplicationContext());
        this.dao = db.getContactsDao();
        executorService = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public void addContact(Contacts contacts){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                dao.insert(contacts);
            }
        });

    }

    public void delete(Contacts contacts){
       executorService.execute(new Runnable() {
           @Override
           public void run() {
               dao.delete(contacts);
           }
       });
    }

    public LiveData<List<Contacts>> getAll(){
       return dao.getAllContacts();
    }


}
