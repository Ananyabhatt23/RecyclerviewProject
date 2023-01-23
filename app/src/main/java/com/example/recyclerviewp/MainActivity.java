package com.example.recyclerviewp;

import static com.example.recyclerviewp.R.id.recycview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewp.adapter.ContactsAdapter;
import com.example.recyclerviewp.data.Contacts;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycview);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactsAdapter(getdata()));
    }

    private ArrayList<Contacts> getdata()
    {
        ArrayList<Contacts> list = new ArrayList<>();
        Contacts c1 = new Contacts("Ananya","7022340976",R.drawable.minimouse);list.add(c1);
        Contacts c2 = new Contacts("Upma","7022340956",R.drawable.tom);list.add(c2);
        Contacts c3 = new Contacts("soundarya","7022340976",R.drawable.jerry);list.add(c3);
        Contacts c4 = new Contacts("Manasa","7022340946",R.drawable.tom);list.add(c4);
        Contacts c5 = new Contacts("Aishwarya","7024340976",R.drawable.minimouse);list.add(c5);
        Contacts c6 = new Contacts("Ramya","7022340976",R.drawable.minimouse);list.add(c6);
        Contacts c7 = new Contacts("Samruddhi","7022340976",R.drawable.jerry);list.add(c7);
        Contacts c8 = new Contacts("Kavita","7022320976",R.drawable.tom);list.add(c8);
        return  list;

    }
}