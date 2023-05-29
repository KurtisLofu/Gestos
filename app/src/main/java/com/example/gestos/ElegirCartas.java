package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.example.gestos.database.Carta;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ElegirCartas extends AppCompatActivity {

    Spinner spFacil;
    Spinner spMedio;
    Spinner spDificil;

    ArrayList<Equipo> teams = new ArrayList<>();
    String palabra;
    Equipo activo = null;
    int turno;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_cartas);

        spFacil = findViewById(R.id.spinnerFacil);
        spMedio = findViewById(R.id.spinnerMedio);
        spDificil = findViewById(R.id.spinnerDificil);

        i = getIntent();
        turno = i.getIntExtra("turno", -1);
        teams = i.getParcelableArrayListExtra("equipos");
        activo = teams.get(turno);


    }

    public void startGame(View view) {

        int facilNum = Integer.valueOf(spFacil.getSelectedItem().toString());
        int medioNum = Integer.valueOf(spMedio.getSelectedItem().toString());
        int dificilNum = Integer.valueOf(spDificil.getSelectedItem().toString());

        if (facilNum + medioNum + dificilNum != 4) {
            Snackbar.make(
                    view,
                    "Selecciona exactamente 4 cartas.",
                    BaseTransientBottomBar.LENGTH_SHORT
            ).show();
        }
        else {
            ArrayList<Carta> cartasToPlay = getCartasToPlay();
            Intent i = new Intent(this, GameActivity.class);
            startActivityForResult(i, 0);
        }
    }

//    public ArrayList<Carta> getCartasToPlay() {
//
//    }
}