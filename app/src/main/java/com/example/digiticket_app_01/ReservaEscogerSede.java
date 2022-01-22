package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ReservaEscogerSede extends AppCompatActivity {

    private ConstraintLayout btnCiudadUniversitaria;
    private ConstraintLayout btnCangallo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_escoger_sede);

        btnCiudadUniversitaria = findViewById(R.id.btnEscogerSedeCU);
        //creando listener
        btnCiudadUniversitaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaEscogerSede.this, ReservaEscogerPlato.class));
            }
        });
    }
}