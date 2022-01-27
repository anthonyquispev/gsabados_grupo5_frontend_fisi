package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.digiticket_app_01.configuracion.Sistema;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReservaEscogerTurno extends AppCompatActivity {
    private ConstraintLayout lyTurno1;
    private ConstraintLayout lyTurno2;
    private ConstraintLayout lyTurno3;
    private ConstraintLayout lyTurno4;
    private ConstraintLayout lyTurno5;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    //para modificar fondo y texto de opcion seleccionada
    private TextView txtTurno1;
    private TextView txtTicketsDisponiblesT1;
    private TextView txtTurno2;
    private TextView txtTicketsDisponiblesT2;
    private TextView txtTurno3;
    private TextView txtTicketsDisponiblesT3;
    private TextView txtTurno4;
    private TextView txtTicketsDisponiblesT4;
    private TextView txtTurno5;
    private TextView txtTicketsDisponiblesT5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_escoger_turno);

        String sede = getIntent().getStringExtra("sede");
        String user_id = getIntent().getStringExtra("user_id");

        //txt
        txtTurno1 = findViewById(R.id.txtTurno1);
        txtTurno2 = findViewById(R.id.txtTurno2);
        txtTurno3 = findViewById(R.id.txtTurno3);
        txtTurno4 = findViewById(R.id.txtTurno4);
        txtTurno5 = findViewById(R.id.txtTurno5);
        txtTicketsDisponiblesT1 = findViewById(R.id.txtTickesDisponiblesT1);
        txtTicketsDisponiblesT2 = findViewById(R.id.txtTicketsDisponiblesT2);
        txtTicketsDisponiblesT3 = findViewById(R.id.txtTicketsDisponiblesT3);
        txtTicketsDisponiblesT4 = findViewById(R.id.txtTicketsDisponiblesT4);
        txtTicketsDisponiblesT5 = findViewById(R.id.txtTicketsDisponiblesT5);

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno1 = findViewById(R.id.btnEscogerSedeCangallo);
        //creando listener
        lyTurno1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //cambiando fondo y texto
                lyTurno1.setBackground(getDrawable(R.drawable.btn_aceptar_turno));
                txtTicketsDisponiblesT1.setTextColor(getResources().getColor(R.color.white));
                txtTurno1.setTextColor(getResources().getColor(R.color.white));
                //abriendo activity Resumen de Reserva
                Intent i = new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class);
                i.putExtra("user_id", user_id);
                i.putExtra("sede", sede);
                i.putExtra("turno_id", Sistema.turno_id_1);
                i.putExtra("turno_numero", Sistema.turno_numero_1);
                i.putExtra("turno_horario", Sistema.turno_horario_1);
                startActivity(i);
//                startActivity(new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class));
            }
        });

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno2 = findViewById(R.id.layoutTurno2);
        //creando listener
        lyTurno2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //cambiando fondo y texto
                lyTurno2.setBackground(getDrawable(R.drawable.btn_aceptar_turno));
                txtTicketsDisponiblesT2.setTextColor(getResources().getColor(R.color.white));
                txtTurno2.setTextColor(getResources().getColor(R.color.white));
                //abriendo activity Resumen de Reserva
                Intent i = new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class);
                i.putExtra("user_id", user_id);
                i.putExtra("sede", sede);
                i.putExtra("turno_id", Sistema.turno_id_2);
                i.putExtra("turno_numero", Sistema.turno_numero_2);
                i.putExtra("turno_horario", Sistema.turno_horario_2);
                startActivity(i);
//                startActivity(new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class));
            }
        });

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno3 = findViewById(R.id.layoutTurno3);
        //creando listener
        lyTurno3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //cambiando fondo y texto
                lyTurno3.setBackgroundColor(getResources().getColor(R.color.orange));
                lyTurno3.setBackground(getDrawable(R.drawable.btn_aceptar_turno));
                txtTicketsDisponiblesT3.setTextColor(getResources().getColor(R.color.white));
                txtTurno3.setTextColor(getResources().getColor(R.color.white));
                //abriendo activity Resumen de Reserva
                Intent i = new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class);
                i.putExtra("user_id", user_id);
                i.putExtra("sede", sede);
                i.putExtra("turno_id", Sistema.turno_id_3);
                i.putExtra("turno_numero", Sistema.turno_numero_3);
                i.putExtra("turno_horario", Sistema.turno_horario_3);
                startActivity(i);
//                startActivity(new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class));
            }
        });

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno4 = findViewById(R.id.layoutTurno4);
        //creando listener
        lyTurno4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //cambiando fondo y texto
                lyTurno4.setBackground(getDrawable(R.drawable.btn_aceptar_turno));
                txtTicketsDisponiblesT4.setTextColor(getResources().getColor(R.color.white));
                txtTurno4.setTextColor(getResources().getColor(R.color.white));
                //abriendo activity Resumen de Reserva
                Intent i = new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class);
                i.putExtra("user_id", user_id);
                i.putExtra("sede", sede);
                i.putExtra("turno_id", Sistema.turno_id_4);
                i.putExtra("turno_numero", Sistema.turno_numero_4);
                i.putExtra("turno_horario", Sistema.turno_horario_4);
                startActivity(i);
//                startActivity(new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class));
            }
        });

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno5 = findViewById(R.id.layoutTurno5);
        //creando listener
        lyTurno5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //cambiando fondo y texto
                lyTurno5.setBackground(getDrawable(R.drawable.btn_aceptar_turno));
                txtTicketsDisponiblesT5.setTextColor(getResources().getColor(R.color.white));
                txtTurno5.setTextColor(getResources().getColor(R.color.white));
                //abriendo activity Resumen de Reserva
                Intent i = new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class);
                i.putExtra("user_id", user_id);
                i.putExtra("sede", sede);
                i.putExtra("turno_id", Sistema.turno_id_5);
                i.putExtra("turno_numero", Sistema.turno_numero_5);
                i.putExtra("turno_horario", Sistema.turno_horario_5);
                startActivity(i);
//                startActivity(new Intent(ReservaEscogerTurno.this, ReservaEscogerPlato.class));
            }
        });

        //para retroceder
        btnRetroceder = findViewById(R.id.floatingActionButtonBackSede);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaEscogerTurno.this, ReservaEscogerSede.class));
            }
        });
    }
}