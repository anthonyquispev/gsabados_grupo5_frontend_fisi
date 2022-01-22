package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class MiPerfilModalReservaCancelada extends AppCompatActivity {

    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_modal_reserva_cancelada);

        //obteniendo objeto Pantalla
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //obteniendo ancho y alto de la pantalla
        int width = medidasVentana.widthPixels;
        int height = medidasVentana.heightPixels;
        //restringiendo el tamaño del modal
        getWindow().setLayout((int) (width*0.75), (int) (height*0.30));



        //linkeando el boton del modal con el activity Mostrar Ticket
        btnAceptar = findViewById(R.id.btnAceptarModal3);
        //creando listener
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finalizando el activity
                finish();
            }
        });
    }
}