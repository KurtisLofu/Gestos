package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Equipo> equipos = new ArrayList<>();
    EditText etSegundosPorRonda;
    EditText etNumeroDeRondas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSegundosPorRonda = findViewById(R.id.etSegundosRonda);
        etNumeroDeRondas = findViewById(R.id.etNumeroRondas);
        addEditTextListener();
    }

    public void startActivityTablero(View view) {
        try {
            int segundosPorRonda = Integer.valueOf(etSegundosPorRonda.getText().toString());
            int numeroDeRondas = Integer.valueOf(etNumeroDeRondas.getText().toString());

            if (segundosPorRonda > 0 && numeroDeRondas > 0) {
                Intent i = new Intent(this, Tablero.class);
                i.putParcelableArrayListExtra("equipos", equipos);
                i.putExtra("segundosPorRonda", segundosPorRonda);
                i.putExtra("numeroDeRondas", numeroDeRondas);
                startActivity(i);
            }
        } catch (Exception ex) {
            Log.i("ppppp", ex.getMessage());
        }
    }

    public void addEditTextListener() {
        final EditText edittext = findViewById(R.id.etNombreEquipo);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    String nombreEquipo = edittext.getText().toString();

                    Toast.makeText(MainActivity.this, nombreEquipo, Toast.LENGTH_SHORT).show();

                    if (!nombreEquipo.equals(""))
                        equipos.add(new Equipo(nombreEquipo));

                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.BtnMenuAddPalabra) {
            //startCreatePlayerActivity();
        } else if (item.getItemId() == R.id.BtnMenuGestionarPalabra) {
            Intent intent = new Intent(this, ManageCarta.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.BtnMenuConfig) {
            //checkAllCtv();
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}