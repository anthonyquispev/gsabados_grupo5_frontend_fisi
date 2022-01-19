package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class MiPerfilModalCerrarSesion extends AppCompatActivity {

    //variables para el modal
    private TextView txtCancelar;
    private TextView txtCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_modal_cerrar_sesion);

        //obteniendo objeto Pantalla
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //obteniendo ancho y alto de la pantalla
        int width = medidasVentana.widthPixels;
        int height = medidasVentana.heightPixels;
        //restringiendo el tamaño del modal
        getWindow().setLayout((int) (width*0.75), (int) (height*0.30));

        //Linkeando el boton Cancelar
        txtCancelar = findViewById(R.id.txtCancelarModal4);
        //creando listener
        txtCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cerrando el modal actual
                finish();
            }
        });

        //Linkeando el boton Cerrar Sesion
        txtCerrarSesion = findViewById(R.id.txtCerrarSesionModal4);
        //creando listener
        txtCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cerrando el modal actual
                finish();
            }
        });
    }
}