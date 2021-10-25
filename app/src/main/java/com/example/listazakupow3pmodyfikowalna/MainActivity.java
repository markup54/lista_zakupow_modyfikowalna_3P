package com.example.listazakupow3pmodyfikowalna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Produkt> wszystkieProdukty
            = new ArrayList<>();
    private RecyclerView zakupyRecyclerView;
    private ZakupyAdapter zakupyAdapter;
    private SharedPreferences zakupySharedPreferences;
    private static final String LISTA_KEY = "lista_zakupow";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zakupySharedPreferences = getPreferences(MODE_PRIVATE);
        wszystkieProdukty = odczytajListeZapupow();
        //wszystkieProdukty.add(new Produkt("masło"));
        //wszystkieProdukty.add(new Produkt("bułeczki"));


        zakupyRecyclerView = findViewById(R.id.recyclerView);
        zakupyAdapter
                = new ZakupyAdapter(this,
                wszystkieProdukty);
        zakupyRecyclerView.setAdapter(zakupyAdapter);
        zakupyRecyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        Button dodajButton = (Button) findViewById(R.id.button);

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
                produktText.setText("");
            }
        });
        Button usunButton = (Button) findViewById(R.id.button2);
        usunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO wywolac metode z usuwaniem
                zakupyAdapter.usunProdukt();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        zapiszListeZakupow();
    }
    private ArrayList<Produkt> odczytajListeZapupow(){
        ArrayList<Produkt> odczytaneProdukty;
        Gson gson = new Gson();
        Type type = new TypeToken<List<Produkt>>(){}.getType();
        String odczytanaPreferencja
                = zakupySharedPreferences
                .getString(LISTA_KEY,"");
        odczytaneProdukty
                = gson.fromJson(odczytanaPreferencja,type);
        if(odczytaneProdukty == null){
            odczytaneProdukty = new ArrayList<>();
        }
        return odczytaneProdukty;
    }
    private void zapiszListeZakupow(){
        SharedPreferences.Editor edytor
                = zakupySharedPreferences.edit();
        Gson gson = new Gson();
        String serializowana_lista
                = gson.toJson(wszystkieProdukty);
        edytor.putString(LISTA_KEY,serializowana_lista);
        edytor.apply();
    }
}