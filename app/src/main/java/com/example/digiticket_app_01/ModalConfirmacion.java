package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModalConfirmacion extends AppCompatActivity {

    //variables para el modal
    private TextView txtRegresar;
    private TextView txtConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modal_confirmacion);

        //obteniendo objeto Pantalla
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //obteniendo ancho y alto de la pantalla
        int width = medidasVentana.widthPixels;
        int height = medidasVentana.heightPixels;
        //restringiendo el tamaño del modal
        getWindow().setLayout((int) (width*0.75), (int) (height*0.30));


        //linkeando el modal con el boton
        txtConfirmar = findViewById(R.id.txtConfirmarModal1);
        //creando listener
        txtConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cerrando el modal actual
                finish();
                //iniciando el nuevo modal
                startActivity(new Intent(ModalConfirmacion.this, ModalReservaConfirmada.class));
            }
        });

        txtRegresar = findViewById(R.id.txtRegresarModal1);
        //creando listener
        txtRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cerrando el modal actual
                finish();
            }
        });
    }
}