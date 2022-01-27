package com.example.digiticket_app_01;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.digiticket_app_01.configuracion.Sistema;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

public class ReservaEscogerPlato extends AppCompatActivity {

    private Button btnSiguiente;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    //para escoger nivel
    private Button btnNivel1;
    private Button btnNivel2;

    // CheckBox
    private CheckBox cbTodos, cbEntrada, cbSegundo, cbPostre, cbRefresco;

    private String nivel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_escoger_plato);

        String user_id = getIntent().getStringExtra("user_id");
        String sede = getIntent().getStringExtra("sede");
        String turno_id = getIntent().getStringExtra("turno_id");
        String turno_numero = getIntent().getStringExtra("turno_numero");
        String turno_horario = getIntent().getStringExtra("turno_horario");

        cbTodos = findViewById(R.id.checkBox);
        cbEntrada = findViewById(R.id.checkBox2);
        cbSegundo = findViewById(R.id.checkBox3);
        cbPostre = findViewById(R.id.checkBox4);
        cbRefresco = findViewById(R.id.checkBox5);

        cbTodos.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                cbEntrada.setChecked(true);
                cbSegundo.setChecked(true);
                cbPostre.setChecked(true);
                cbRefresco.setChecked(true);
            } else {
                cbEntrada.setChecked(false);
                cbSegundo.setChecked(false);
                cbPostre.setChecked(false);
                cbRefresco.setChecked(false);
            }
        });

        btnSiguiente = findViewById(R.id.btn_reservar_RR2);
        //creando listener
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReservaEscogerPlato.this, ReservaResumenReserva.class);
                i.putExtra("user_id", user_id);
                i.putExtra("sede", sede);
                i.putExtra("nivel", nivel);
                i.putExtra("turno_id", turno_id);
                i.putExtra("turno_numero", turno_numero);
                i.putExtra("turno_horario", turno_horario);
                //iniciando el modal
                if (cbEntrada.isChecked() == true) {
                    i.putExtra("entrada", Sistema.comida_id_1);
                }
                if (cbSegundo.isChecked() == true) {
                    i.putExtra("segundo", Sistema.comida_id_2);
                }
                if (cbPostre.isChecked() == true) {
                    i.putExtra("postre", Sistema.comida_id_3);
                }
                if (cbRefresco.isChecked() == true) {
                    i.putExtra("refresco", Sistema.comida_id_4);
                }
                startActivity(i);
//                startActivity(new Intent(ReservaEscogerPlato.this, ReservaResumenReserva.class));
            }
        });

        //para retroceder
        btnRetroceder =

                findViewById(R.id.floatingActionButtonBackTurno);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaEscogerPlato.this, ReservaEscogerTurno.class));
            }
        });

        //al seleccionar boton nivel 1
        btnNivel1 =

                findViewById(R.id.buttonEscogerNivel1);
        //creando listener
        btnNivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambiando boton nivel 1
                //cambiando color de texto
                btnNivel1.setTextColor(getResources().getColor(R.color.white));
                //cambiar fondo
                btnNivel1.setBackgroundTintList(ContextCompat.getColorStateList(ReservaEscogerPlato.this, R.color.orange));
                //btnNivel1.setBackgroundResource();

                //Cambiando boton nivel 2
                //cambiando color de texto
                btnNivel2.setTextColor(getResources().getColor(R.color.gris));
                //cambiar fondo
                btnNivel2.setBackgroundTintList(ContextCompat.getColorStateList(ReservaEscogerPlato.this, R.color.white));
                //btnNivel2.setBackgroundResource();
                nivel = "1";
            }
        });

        //al seleccionar boton nivel 2
        btnNivel2 =

                findViewById(R.id.buttonEscogerNivel2);
        //creando listener
        btnNivel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambiando boton nivel 2
                //cambiando color de texto
                btnNivel2.setTextColor(getResources().getColor(R.color.white));
                //cambiar fondo
                btnNivel2.setBackgroundTintList(ContextCompat.getColorStateList(ReservaEscogerPlato.this, R.color.orange));

                //Cambiando boton nivel 1
                //cambiando color de texto
                btnNivel1.setTextColor(getResources().getColor(R.color.gris));
                //cambiar fondo
                btnNivel1.setBackgroundTintList(ContextCompat.getColorStateList(ReservaEscogerPlato.this, R.color.white));
                nivel = "2";
            }
        });
    }
}