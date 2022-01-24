package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class MiPerfilModalCancelar extends AppCompatActivity {

    //variables para el modal
    private TextView txtRegresar;
    private TextView txtCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_modal_cancelar);

        //obteniendo objeto Pantalla
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //obteniendo ancho y alto de la pantalla
        int width = medidasVentana.widthPixels;
        int height = medidasVentana.heightPixels;
        //restringiendo el tamaño del modal
        getWindow().setLayout((int) (width*0.75), (int) (height*0.30));

        //linkeando el modal con el boton Cancelar
        txtCancelar = findViewById(R.id.txtCancelarModal3);
        //creando listener
        txtCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cerrando el modal actual
                finish();
                //iniciando el nuevo modal
                startActivity(new Intent(MiPerfilModalCancelar.this, MiPerfilModalReservaCancelada.class));
            }
        });

        txtRegresar = findViewById(R.id.txtRegresarModal3);
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