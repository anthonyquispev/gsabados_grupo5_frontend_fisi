package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReservaResumenReserva extends AppCompatActivity {

    //variables para el modal
    private Button btnReservar;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_resumen_reserva);

        //abriendo modal para confirmar reserva
        btnReservar = findViewById(R.id.btnInicioFinReserva);
        //creando listener
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaResumenReserva.this, ReservaModalConfirmacion.class));
            }
        });

        //para retroceder
        btnRetroceder = findViewById(R.id.floatingActionButton2);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaResumenReserva.this, ReservaEscogerPlato.class));
            }
        });
    }
}