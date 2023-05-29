package com.example.gestos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Collator;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.gestos.database.Carta;
import com.example.gestos.database.CartaLab;
import com.example.gestos.database.CustomAdapterManageCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageCarta extends AppCompatActivity {

    CartaLab cartaLab;
    CustomAdapterManageCartas customAdapter;
    ListView listView;
    ArrayList<Carta> cartaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_palabras);

        try {
            cartaLab = CartaLab.get(this);

            customAdapter = new CustomAdapterManageCartas(this, R.layout.activity_manage_palabras, cartaList, cartaLab);
            listView = findViewById(R.id.manageListView);
            listView.setAdapter(customAdapter);

            getSavedCartas();

        } catch (Exception ex) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        listView.setAdapter(customAdapter);
        getSavedCartas();
    }


    private void getSavedCartas() {

        cartaList.clear();

        for (int i = 0; i < cartaLab.getAllCartas().size(); i++) {
            cartaList.add(cartaLab.getAllCartas().get(i));
        }

        if (cartaList.size() > 0) {
            Collections.sort(cartaList, new Comparator<Carta>() {
                @Override
                public int compare(Carta carta, Carta t1) {
                    Collator insensitiveStringComparator = Collator.getInstance();
                    insensitiveStringComparator.setStrength(Collator.PRIMARY);
                    return insensitiveStringComparator.compare(carta.getPalabra().toLowerCase(), t1.getPalabra().toLowerCase());
                }
            });
        }
        customAdapter.notifyDataSetChanged();

        Log.i("tttttt", "CartaList size: " + cartaList.size());
    }
}