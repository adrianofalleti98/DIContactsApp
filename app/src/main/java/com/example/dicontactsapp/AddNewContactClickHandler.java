package com.example.dicontactsapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddNewContactClickHandler {
    private Context context;
    private Contacts contacts;
    private MyViewModel viewModel;

    public AddNewContactClickHandler(Context context, Contacts contacts, MyViewModel vm) {
        this.context = context;
        this.contacts = contacts;
        viewModel = vm;
    }

    public void submit(View view){
        Intent i = new Intent(context,MainActivity.class);
        if (contacts.name == null || contacts.email == null)
        {
            Toast.makeText(context, "Riempire i campi", Toast.LENGTH_SHORT).show();
        }
        else{
            viewModel.addContact(contacts);
            context.startActivity(i);
        }
    }
}
