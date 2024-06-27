package com.example.dicontactsapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table1")
public class Contacts {
    //ogni attributo è una colonna della tabella
    //ogni istanza di Contacts è una riga della tabella
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String email;

    public Contacts(String nome, String email) {
        this.name = nome;
        this.email = email;
    }

    public Contacts() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
