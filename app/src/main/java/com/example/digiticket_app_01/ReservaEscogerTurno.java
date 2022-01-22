package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReservaEscogerTurno extends AppCompatActivity {

    private ConstraintLayout lyTurno1;
    private ConstraintLayout lyTurno2;
    private ConstraintLayout lyTurno3;
    private ConstraintLayout lyTurno4;
    private ConstraintLayout lyTurno5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_escoger_turno);

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno1 = findViewById(R.id.layoutTurno1);
        //creando listener
        lyTurno1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo activity Resumen de Reserva
                startActivity(new Intent(ReservaEscogerTurno.this, ReservaResumenReserva.class));
            }
        });

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno2 = findViewById(R.id.layoutTurno2);
        //creando listener
        lyTurno2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo activity Resumen de Reserva
                startActivity(new Intent(ReservaEscogerTurno.this, ReservaResumenReserva.class));
            }
        });

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno3 = findViewById(R.id.layoutTurno3);
        //creando listener
        lyTurno3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo activity Resumen de Reserva
                startActivity(new Intent(ReservaEscogerTurno.this, ReservaResumenReserva.class));
            }
        });

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno4 = findViewById(R.id.layoutTurno4);
        //creando listener
        lyTurno4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo activity Resumen de Reserva
                startActivity(new Intent(ReservaEscogerTurno.this, ReservaResumenReserva.class));
            }
        });

        //linkeando el layout (boton) con activity Resumen de Reserva
        lyTurno5 = findViewById(R.id.layoutTurno5);
        //creando listener
        lyTurno5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo activity Resumen de Reserva
                startActivity(new Intent(ReservaEscogerTurno.this, ReservaResumenReserva.class));
            }
        });
    }
}