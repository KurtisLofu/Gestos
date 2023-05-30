package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.gestos.database.Carta;
import com.example.gestos.database.CartaLab;
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

    CartaLab cartaLab;
    int facilNum;
    int medioNum;
    int dificilNum;

    int segundosPorRonda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_cartas);

        cartaLab = CartaLab.get(this);

        spFacil = findViewById(R.id.spinnerFacil);
        spMedio = findViewById(R.id.spinnerMedio);
        spDificil = findViewById(R.id.spinnerDificil);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, getResources().getStringArray(R.array.spinnerValues));

        spFacil.setAdapter(adapter);
        spMedio.setAdapter(adapter);
        spDificil.setAdapter(adapter);

        i = getIntent();
        turno = i.getIntExtra("turno", -1);
        teams = i.getParcelableArrayListExtra("equipos");
        segundosPorRonda = i.getIntExtra("segundosPorRonda", 40);
        activo = teams.get(turno);


    }

    public void startGame(View view) {

        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(100);

        facilNum = Integer.valueOf(spFacil.getSelectedItem().toString());
        medioNum = Integer.valueOf(spMedio.getSelectedItem().toString());
        dificilNum = Integer.valueOf(spDificil.getSelectedItem().toString());

        if (facilNum + medioNum + dificilNum != 4) {
            Snackbar.make(
                    view,
                    "Selecciona exactamente 4 cartas.",
                    BaseTransientBottomBar.LENGTH_SHORT
            ).show();
        } else {
            ArrayList<Carta> cartasToPlay = getCartasToPlay();
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("turno", turno);
            i.putExtra("equipo", activo);
            i.putExtra("segundosPorRonda", segundosPorRonda);
            i.putParcelableArrayListExtra("cartas", cartasToPlay);
            startActivityForResult(i, 0);
        }
    }

    public ArrayList<Carta> getCartasToPlay() {

        ArrayList<Carta> cartasToPlay = new ArrayList<>();

        if (facilNum > 0)
            cartasToPlay.addAll(cartaLab.getCartasByDificultad(1, facilNum * 2));

        if (medioNum > 0)
            cartasToPlay.addAll(cartaLab.getCartasByDificultad(2, medioNum * 2));

        if (dificilNum > 0)
            cartasToPlay.addAll(cartaLab.getCartasByDificultad(3, dificilNum * 2));

        cartaLab.setIsUsedTrueCartas(cartasToPlay);

        return cartasToPlay;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /** Recibe el equipo actualizado con los puntos y el turno **/
        activo = data.getParcelableExtra("equipo");

        teams.get(turno).setPuntos(activo.getPuntos());

        turno = data.getIntExtra("turno", 0);

        i.putExtra("equipo", activo);
        i.putExtra("turno", turno);
        i.putExtra("equipos", teams);
        setResult(RESULT_OK, i);
        finish();


    }
}