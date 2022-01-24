package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class RegistroUsuarioModalCancelarRegistro extends AppCompatActivity {

    //variables para el modal
    private TextView txtRegresar;
    private TextView txtSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario_modal_cancelar_registro);

        //obteniendo objeto Pantalla
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //obteniendo ancho y alto de la pantalla
        int width = medidasVentana.widthPixels;
        int height = medidasVentana.heightPixels;
        //restringiendo el tamaño del modal
        getWindow().setLayout((int) (width*0.75), (int) (height*0.30));

        //Linkeando el boton Regresar
        txtRegresar = findViewById(R.id.txtCancelarRegistroRegresar);
        //creando listener
        txtRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cerrando el modal actual
                finish();
            }
        });

        //Linkeando el boton Salir
        txtSalir = findViewById(R.id.txtCancelarRegistroSalir);
        //creando listener
        txtSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cerrando el modal actual
                startActivity(new Intent(RegistroUsuarioModalCancelarRegistro.this, LoginCodigoUniversitario.class));
            }
        });
    }
}