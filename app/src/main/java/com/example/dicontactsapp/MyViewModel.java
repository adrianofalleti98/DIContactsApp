package com.example.dicontactsapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private MyRepository rep;
    private LiveData<List<Contacts>> allContacts;
    public MyViewModel(@NonNull Application application) {
        super(application);
        rep = new MyRepository(application);
    }

    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = rep.getAll();
        return allContacts;
    }

    public void addContact(Contacts contacts){
        rep.addContact(contacts);
    }

    public void deleteContact(Contacts contacts){
        rep.delete(contacts);
    }
}
