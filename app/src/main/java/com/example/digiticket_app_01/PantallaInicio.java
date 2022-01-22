package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaInicio extends AppCompatActivity {
    private ImageButton btnVerDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        btnVerDetalle = findViewById(R.id.btnVerDetalle);

        //creando listener
        btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(PantallaInicio.this, ModalDetalleEntrada.class));
            }
        });
    }
}