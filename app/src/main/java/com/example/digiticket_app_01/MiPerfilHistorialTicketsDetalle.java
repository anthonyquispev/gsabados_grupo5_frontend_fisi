package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class MiPerfilHistorialTicketsDetalle extends AppCompatActivity {

    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_historial_tickets_detalle);

        //obteniendo objeto Pantalla
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //obteniendo ancho y alto de la pantalla
        int width = medidasVentana.widthPixels;
        int height = medidasVentana.heightPixels;
        //restringiendo el tamaño del modal
        getWindow().setLayout((int) (width*0.80), (int) (height*0.80));



        //linkeando el boton del modal con el activity Mostrar Ticket
        btnVolver = findViewById(R.id.btnVolver);
        //creando listener
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //regresando a Mi Perfil principal
                startActivity(new Intent(MiPerfilHistorialTicketsDetalle.this, MiPerfilHistorialTickets.class));
            }
        });
    }
}