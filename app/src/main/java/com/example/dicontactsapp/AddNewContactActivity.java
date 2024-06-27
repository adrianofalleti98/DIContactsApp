package com.example.dicontactsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.dicontactsapp.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private Contacts contact;

    private AddNewContactClickHandler handler;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        contact = new Contacts();
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_contact);
        binding.setContact(contact); //cosi l'edit text può settare gli attributi per come abbiamo scritto il file xml
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        handler = new AddNewContactClickHandler(this,contact,viewModel);
        binding.setClick(handler);
    }
}