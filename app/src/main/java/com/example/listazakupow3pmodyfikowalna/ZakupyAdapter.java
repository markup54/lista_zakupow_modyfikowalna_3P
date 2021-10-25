package com.example.listazakupow3pmodyfikowalna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ZakupyAdapter
        extends RecyclerView
        .Adapter<ZakupyAdapter.ProduktViewHolder> {

    private ArrayList<Produkt> produkty;
    private LayoutInflater inflater;

    public ZakupyAdapter(Context context,
                         ArrayList<Produkt> produkty) {
        inflater = LayoutInflater.from(context);
        this.produkty = produkty;
    }

    @NonNull
    @Override
    public ProduktViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType) {
        View produktItemView = inflater
                .inflate(R.layout.item_view,
                        parent,
                        false);
        return new ProduktViewHolder(produktItemView,
                this);
    }

    @Override
    public void onBindViewHolder
            (@NonNull ProduktViewHolder holder,
             int position) {
        Produkt aktualnyProdukt = produkty.get(position);
        holder.checkBoxItem
                .setText(aktualnyProdukt.getNazwa());
        holder.checkBoxItem
                .setChecked(aktualnyProdukt.isZaznaczony());

    }

    @Override
    public int getItemCount() {
        return produkty.size();
    }

    public class ProduktViewHolder
            extends RecyclerView.ViewHolder{
        public ZakupyAdapter zakupyAdapter;
        public CheckBox checkBoxItem;

        public ProduktViewHolder(@NonNull View itemView,
                                 ZakupyAdapter adapter) {
            super(itemView);
            this.zakupyAdapter = adapter;
            this.checkBoxItem
                    = itemView.findViewById(R.id.checkBox);
        }
    }
}
