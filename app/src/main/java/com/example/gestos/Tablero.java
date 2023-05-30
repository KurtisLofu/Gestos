package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.gestos.database.Carta;

import java.util.ArrayList;

public class Tablero extends AppCompatActivity {

    ArrayList<Equipo> equipos;
    int segundosPorRonda;
    int numeroDeRondas;
    int segundosPorPalabra;
    int turno = 0;
    int rondaActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        /** Recibe equipos, segundos por ronda y número de rondas **/
        equipos = getIntent().getParcelableArrayListExtra("equipos");
        segundosPorRonda = getIntent().getIntExtra("segundosPorRonda", 40);
        segundosPorPalabra = segundosPorRonda / 4;
        numeroDeRondas = getIntent().getIntExtra("numeroDeRondas", 10) * 2;

        escribirPuntuaciones(null);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /** Recibe el equipo actualizado con los puntos y el turno **/
        equipos = data.getParcelableArrayListExtra("equipos");

        turno = data.getIntExtra("turno", 0);

        /** Si el turno llega al ultimo equipo, se reinicia */
        if (turno > equipos.size() - 1)
            turno = 0;

        escribirPuntuaciones(null);

        /** Comprueba fin del juego */
        if (rondaActual >= numeroDeRondas) {
            /** StartActivity FinDelJuego **/
//            Intent intent = new Intent(this, Victoria.class);
//            intent.putExtra("ganador", t);
//            startActivity(intent);
//            finish();
        }
    }

    public void escribirPuntuaciones(View view) {
        TextView tv = findViewById(R.id.tvTablero);
        String msg = "";
        for (Equipo t : equipos) {
            if (t.id == turno) {
                msg += "<font color='#FFD700'>➤" + t.toString() + "</font> - " + t.getPuntos() + (equipos.size() > 4 ? "<br>" : "<br/><br/>");
            } else
                msg += "    " + t.toString() + " - " + t.getPuntos() + (equipos.size() > 4 ? "<br>" : "<br/><br/>");
        }
        tv.setText(Html.fromHtml(msg));
    }

    public void startElegirPalabraActivity(View view) {
        Intent intent = new Intent(this, ElegirCartas.class);
        intent.putExtra("turno", turno);
        intent.putExtra("equipos", equipos);
        intent.putExtra("segundosPorRonda", segundosPorRonda);

        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(150);

        startActivityForResult(intent, 1);
    }
}