package com.example.dicontactsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dicontactsapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private ArrayList<Contacts> contacts;

    public MyAdapter(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();//notifica la recyclerview di aggiornarsi
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    ContactListItemBinding clib = DataBindingUtil.
            inflate(LayoutInflater.from(parent.getContext())
                    ,R.layout.contact_list_item
                    ,parent
                    ,false);
    return new ContactViewHolder(clib);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacts c = contacts.get(position);
        holder.contactListItemBinding.setC(c);
    }

    @Override
    public int getItemCount() {
       if (contacts != null)
           return contacts.size();
       return 0;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        private ContactListItemBinding contactListItemBinding;
        public ContactViewHolder(@NonNull ContactListItemBinding binding) {
            super(binding.getRoot());
            this.contactListItemBinding = binding;
        }
    }
}
