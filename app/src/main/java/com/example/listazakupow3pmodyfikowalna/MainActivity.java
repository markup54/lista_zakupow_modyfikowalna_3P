package com.example.listazakupow3pmodyfikowalna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        //TODO zadeklarować buttony
        Button dodajButton = (Button) findViewById(R.id.button);
        //TODO dodac nasłuchiwanie na dodawanie produkty
        dodajButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText produktText
                        = (EditText) findViewById(R.id.editText);
                String odczytanyProdukt
                        = String.valueOf(produktText.getText());
                if(odczytanyProdukt.length()>0) {
                    Produkt produkt = new Produkt(odczytanyProdukt);
                    zakupyAdapter.dodajProdukt(produkt);
                }
            }
        });

        //TODO dodac nasłuchiwanie na usuwanie produktu
    }
}