package com.example.recyclerviewp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.recyclerviewp.adapter.ContactsAdapter;
import com.example.recyclerviewp.data.Contacts;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    SearchView searchView;
ArrayList<Contacts> Clist = new ArrayList<>();
    LinearLayout linearLayout;
    ContactsAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linear_layout);

         recyclerView = findViewById(R.id.recycview);

        searchView = findViewById(R.id.searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         adapter= new ContactsAdapter(getdata());
        recyclerView.setAdapter(adapter);
    }

    private void filter(String newText) {
        ArrayList<Contacts> filteredList = new ArrayList<>();
        for (Contacts item : Clist) {
            if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(item);
            }

        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "not found", Toast.LENGTH_SHORT).show();
        } else {
            ContactsAdapter contactsAdapter = new ContactsAdapter(filteredList);
            recyclerView.setAdapter(contactsAdapter);
            contactsAdapter.notifyDataSetChanged();
        }
    }
    private ArrayList<Contacts> getdata() {
        Contacts c1 = new Contacts("Ananya", "7022340976", R.drawable.person1);
        Clist.add(c1);
        Contacts c2 = new Contacts("Upma", "7022340956", R.drawable.person2);
        Clist.add(c2);
        Contacts c3 = new Contacts("Soundarya", "7022340976", R.drawable.person2);
        Clist.add(c3);
        Contacts c4 = new Contacts("Manasa", "7022340946", R.drawable.person1);
        Clist.add(c4);
        Contacts c5 = new Contacts("Aishwarya", "7024340976", R.drawable.person2);
        Clist.add(c5);
        Contacts c6 = new Contacts("Ramya", "7022340976", R.drawable.person2);
        Clist.add(c6);
        Contacts c7 = new Contacts("Samruddhi", "7022340976", R.drawable.person1);
        Clist.add(c7);
        Contacts c8 = new Contacts("Kavita", "7022320976", R.drawable.person1);
        Clist.add(c8);
        return Clist;

    }

    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Snackbar snackbar = Snackbar.make(linearLayout,"Item Deleted!", Snackbar.LENGTH_LONG);
            snackbar.show();
            Clist.remove(viewHolder.getBindingAdapterPosition());
            adapter.notifyDataSetChanged();
        }
    };
}