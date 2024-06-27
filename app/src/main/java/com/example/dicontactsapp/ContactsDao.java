package com.example.dicontactsapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactsDao { //l'implementazione la farà poi android studio
    @Insert
    void insert(Contacts contacts);
    @Delete
    void delete(Contacts contacts);
   @Query("SELECT * FROM contacts_table1")
    LiveData<List<Contacts>> getAllContacts();
}
