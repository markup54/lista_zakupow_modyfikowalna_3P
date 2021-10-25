package com.example.listazakupow3pmodyfikowalna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Produkt> wszystkieProdukty
            = new ArrayList<>();
    private RecyclerView zakupyRecyclerView;
    private ZakupyAdapter zakupyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wszystkieProdukty.add(new Produkt("masełko"));
        wszystkieProdukty.add(new Produkt("bułeczki"));

        zakupyRecyclerView = findViewById(R.id.recyclerView);
        zakupyAdapter
                = new ZakupyAdapter(this,
                wszystkieProdukty);
        zakupyRecyclerView.setAdapter(zakupyAdapter);
        zakupyRecyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );
    }
}