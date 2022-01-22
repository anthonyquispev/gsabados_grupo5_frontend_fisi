package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReservaEscogerPlato extends AppCompatActivity {

    private Button btnSiguiente;

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
                startActivity(new Intent(ReservaEscogerPlato.this, ReservaEscogerTurno.class));
            }
        });
    }
}