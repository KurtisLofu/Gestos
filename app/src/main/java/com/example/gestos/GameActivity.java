package com.example.gestos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gestos.database.Carta;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GameActivity extends AppCompatActivity {

    Equipo activo = null;
    int turno;
    Intent i;

    TextView tv1Arriba;
    TextView tv1Abajo;
    Button btnTv1;

    TextView tv2Arriba;
    TextView tv2Abajo;
    Button btnTv2;

    TextView tv3Arriba;
    TextView tv3Abajo;
    Button btnTv3;

    TextView tv4Arriba;
    TextView tv4Abajo;
    Button btnTv4;

    Button btnEmpezar;

    TextView[] tvArray = new TextView[8];

    ArrayList<Carta> cartasToPlay = new ArrayList<Carta>();

    int segundosPorRonda;

    TextView tvTimeDebug;

    ImageView ivSwap1;
    ImageView ivSwap2;
    ImageView ivSwap3;
    ImageView ivSwap4;

    boolean firstGone = false;
    boolean secondGone = false;
    boolean thirdGone = false;
    Vibrator vb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        ivSwap1 = findViewById(R.id.ivSwap1);
        ivSwap2 = findViewById(R.id.ivSwap2);
        ivSwap3 = findViewById(R.id.ivSwap3);
        ivSwap4 = findViewById(R.id.ivSwap4);

        btnEmpezar = findViewById(R.id.btnEmpezar);
        tvTimeDebug = findViewById(R.id.tvTimeDebug);

        tv1Arriba = findViewById(R.id.tv1Arriba);
        tv1Abajo = findViewById(R.id.tv1Abajo);
        btnTv1 = findViewById(R.id.btnTv1);

        tv2Arriba = findViewById(R.id.tv2Arriba);
        tv2Abajo = findViewById(R.id.tv2Abajo);
        btnTv2 = findViewById(R.id.btnTv2);

        tv3Arriba = findViewById(R.id.tv3Arriba);
        tv3Abajo = findViewById(R.id.tv3Abajo);
        btnTv3 = findViewById(R.id.btnTv3);

        tv4Arriba = findViewById(R.id.tv4Arriba);
        tv4Abajo = findViewById(R.id.tv4Abajo);
        btnTv4 = findViewById(R.id.btnTv4);

        tvArray[0] = tv1Arriba;
        tvArray[1] = tv1Abajo;
        tvArray[2] = tv2Arriba;
        tvArray[3] = tv2Abajo;
        tvArray[4] = tv3Arriba;
        tvArray[5] = tv3Abajo;
        tvArray[6] = tv4Arriba;
        tvArray[7] = tv4Abajo;

        i = getIntent();
        turno = i.getIntExtra("turno", -1);
        activo = i.getParcelableExtra("equipo");
        cartasToPlay = i.getParcelableArrayListExtra("cartas");
        segundosPorRonda = i.getIntExtra("segundosPorRonda", 40);

        setCartasOnTable();
        setOnTVClickListeners();
        setOnBtnClickListeners();

    }

    private void setOnBtnClickListeners() {
        btnTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activo.puntos += cartasToPlay.get(0).getDificultad();
                btnTv1.setVisibility(View.GONE);
                firstGone = true;
                vb.vibrate(150);
            }
        });

        btnTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activo.puntos += cartasToPlay.get(2).getDificultad();
                btnTv2.setVisibility(View.GONE);
                secondGone = true;
                vb.vibrate(150);
            }
        });

        btnTv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activo.puntos += cartasToPlay.get(4).getDificultad();
                btnTv3.setVisibility(View.GONE);
                thirdGone = true;
                vb.vibrate(150);
            }
        });

        btnTv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activo.puntos += cartasToPlay.get(6).getDificultad();
                vb.vibrate(150);
                endActivityAndSendResult();
            }
        });
    }

    private void setCartasOnTable() {

        Collections.sort(cartasToPlay, Comparator.comparing(Carta::getDificultad));

        for (int j = 0; j < cartasToPlay.size(); j++) {

            Carta cartaAux = cartasToPlay.get(j);

            if (cartaAux.getDificultad() == 1) {
                tvArray[j].setTextColor(Color.parseColor("#21de54"));
            } else if (cartaAux.getDificultad() == 2) {
                tvArray[j].setTextColor(Color.parseColor("#e6ed15"));
            } else {
                tvArray[j].setTextColor(Color.parseColor("#ff5e5e"));
            }
            tvArray[j].setText(cartaAux.getPalabra());
        }
    }

    private void setOnTVClickListeners() {
        ivSwap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = tv1Arriba.getText().toString();
                tv1Arriba.setText(tv1Abajo.getText().toString());
                tv1Abajo.setText(aux);
                vb.vibrate(150);
            }
        });

        ivSwap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = tv2Arriba.getText().toString();
                tv2Arriba.setText(tv2Abajo.getText().toString());
                tv2Abajo.setText(aux);
                vb.vibrate(150);
            }
        });
        ivSwap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = tv3Arriba.getText().toString();
                tv3Arriba.setText(tv3Abajo.getText().toString());
                tv3Abajo.setText(aux);
                vb.vibrate(150);
            }
        });

        ivSwap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = tv4Arriba.getText().toString();
                tv4Arriba.setText(tv4Abajo.getText().toString());
                tv4Abajo.setText(aux);
                vb.vibrate(150);
            }
        });
    }

    public void ButtonEmpezarClick(View view) {

        vb.vibrate(175);

        btnTv1.setVisibility(View.VISIBLE);
        btnTv2.setVisibility(View.VISIBLE);
        btnTv3.setVisibility(View.VISIBLE);
        btnTv4.setVisibility(View.VISIBLE);


        tv1Abajo.setVisibility(View.GONE);
        tv2Abajo.setVisibility(View.GONE);
        tv3Abajo.setVisibility(View.GONE);
        tv4Abajo.setVisibility(View.GONE);
        ivSwap1.setVisibility(View.GONE);
        ivSwap2.setVisibility(View.GONE);
        ivSwap3.setVisibility(View.GONE);
        ivSwap4.setVisibility(View.GONE);
        btnEmpezar.setVisibility(View.GONE);

        int milsegundosPorRonda = segundosPorRonda * 1000;

        firstGone = false;
        secondGone = false;
        thirdGone = false;



        new CountDownTimer(milsegundosPorRonda, 1000) {
            public void onTick(long millisUntilFinished) {

                tvTimeDebug.setText("" + millisUntilFinished / 1000);

                if (millisUntilFinished <= milsegundosPorRonda - (milsegundosPorRonda / 4) && !firstGone) {
                    btnTv1.setVisibility(View.GONE);
                    firstGone = true;
                    vb.vibrate(150);


                } else if (millisUntilFinished <= milsegundosPorRonda - ((milsegundosPorRonda / 4) * 2) && !secondGone) {
                    btnTv2.setVisibility(View.GONE);
                    secondGone = true;
                    vb.vibrate(150);
                } else if (millisUntilFinished <= milsegundosPorRonda - ((milsegundosPorRonda / 4) * 3) && !thirdGone) {
                    btnTv3.setVisibility(View.GONE);
                    thirdGone = true;
                    vb.vibrate(150);
                }

            }

            public void onFinish() {
                btnTv4.setVisibility(View.GONE);
                vb.vibrate(250);
                tvTimeDebug.setText("Done");

                endActivityAndSendResult();
            }
        }.start();

    }

    private void endActivityAndSendResult() {
        i.putExtra("turno", turno + 1);
        i.putExtra("equipo", activo);
        setResult(RESULT_OK, i);
        finish();
    }
}