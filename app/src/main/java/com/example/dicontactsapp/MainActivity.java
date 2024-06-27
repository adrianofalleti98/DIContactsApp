package com.example.dicontactsapp;

import android.os.Bundle;
import com.example.dicontactsapp.DI.App;
import android.view.LayoutInflater;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dicontactsapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Contacts> contatti = new ArrayList<>();
    private MyAdapter adapter;
    private MainActivityClickHandler click;
    private ActivityMainBinding binding;
    @Inject
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        click = new MainActivityClickHandler(this);
        binding.setClick(click);
        RecyclerView rcv = binding.rcv;
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setHasFixedSize(true);


        App.getApp().getComponent().inject(this);
        MyViewModel vm = new ViewModelProvider(this).get(MyViewModel.class);

        Contacts c1 = new Contacts("Adri","gmail");

        vm.addContact(c1);
        List<Contacts> dbcont = vm.getAllContacts().getValue();




        vm.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contatti.clear();
                for (Contacts c : contacts){
                    contatti.add(c);
                }

                adapter.notifyDataSetChanged();

            }
        });
        adapter = new MyAdapter((ArrayList<Contacts>) contatti);

        rcv.setAdapter(adapter);
    }
}