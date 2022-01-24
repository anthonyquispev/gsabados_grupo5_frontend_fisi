package com.example.digiticket_app_01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReservaEscogerSede extends AppCompatActivity {

    private ConstraintLayout btnCiudadUniversitaria;
    private ConstraintLayout btnCangallo;
    //texto
    private TextView txtSedeCiudadUni;
    private TextView txtSedeCangallo;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_escoger_sede);

        //txt
        txtSedeCiudadUni = findViewById(R.id.textViewCU);
        txtSedeCangallo = findViewById(R.id.textViewSedeCangallo);

        //elegir C. Universitaria
        btnCiudadUniversitaria = findViewById(R.id.btnEscogerSedeCU);
        //creando listener
        btnCiudadUniversitaria.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //cambiando fondo y texto
                btnCiudadUniversitaria.setBackground(getDrawable(R.drawable.btn_aceptar_sede));
                //btnCiudadUniversitaria.setBackgroundResource();
                txtSedeCiudadUni.setTextColor(getResources().getColor(R.color.white));
                //iniciando el modal
                startActivity(new Intent(ReservaEscogerSede.this, ReservaEscogerTurno.class));
            }
        });

        //elegir Cangallo
        btnCangallo = findViewById(R.id.btnEscogerSedeCangallo);
        //creando listener
        btnCangallo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //cambiando fondo y texto
                btnCangallo.setBackground(getDrawable(R.drawable.btn_aceptar_sede));
                //btnCangallo.setBackgroundResource();
                txtSedeCangallo.setTextColor(getResources().getColor(R.color.white));
                //iniciando el modal
                startActivity(new Intent(ReservaEscogerSede.this, ReservaEscogerTurno.class));
            }
        });

        //retroceder
        btnRetroceder = findViewById(R.id.floatingActionButton);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaEscogerSede.this, PantallaInicio.class));
            }
        });
    }
}