package com.example.digiticket_app_01;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReservaEscogerPlato extends AppCompatActivity {

    private Button btnSiguiente;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    //para escoger nivel
    private Button btnNivel1;
    private Button btnNivel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_escoger_plato);

        btnSiguiente = findViewById(R.id.btn_reservar_RR2);
        //creando listener
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaEscogerPlato.this, ReservaResumenReserva.class));
            }
        });

        //para retroceder
        btnRetroceder = findViewById(R.id.floatingActionButtonBackTurno);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaEscogerPlato.this, ReservaEscogerTurno.class));
            }
        });

        //al seleccionar boton nivel 1
        btnNivel1 = findViewById(R.id.buttonEscogerNivel1);
        //creando listener
        btnNivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambiando boton nivel 1
                //cambiando color de texto
                btnNivel1.setTextColor(getResources().getColor(R.color.white));
                //cambiar fondo
                btnNivel1.setBackgroundTintList(ContextCompat.getColorStateList(ReservaEscogerPlato.this,R.color.orange));
                //btnNivel1.setBackgroundResource();

                //Cambiando boton nivel 2
                //cambiando color de texto
                btnNivel2.setTextColor(getResources().getColor(R.color.gris));
                //cambiar fondo
                btnNivel2.setBackgroundTintList(ContextCompat.getColorStateList(ReservaEscogerPlato.this,R.color.white));
                //btnNivel2.setBackgroundResource();
            }
        });

        //al seleccionar boton nivel 2
        btnNivel2 = findViewById(R.id.buttonEscogerNivel2);
        //creando listener
        btnNivel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambiando boton nivel 2
                //cambiando color de texto
                btnNivel2.setTextColor(getResources().getColor(R.color.white));
                //cambiar fondo
                btnNivel2.setBackgroundTintList(ContextCompat.getColorStateList(ReservaEscogerPlato.this,R.color.orange));
                //btnNivel2.setBackgroundResource();

                //Cambiando boton nivel 1
                //cambiando color de texto
                btnNivel1.setTextColor(getResources().getColor(R.color.gris));
                //cambiar fondo
                btnNivel1.setBackgroundTintList(ContextCompat.getColorStateList(ReservaEscogerPlato.this,R.color.white));
                //btnNivel1.setBackgroundResource();
            }
        });
    }
}