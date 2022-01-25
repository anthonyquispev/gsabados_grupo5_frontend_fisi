package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class LoginModalContrasenaActualizada extends AppCompatActivity {

    private Button btnAceptarCambiarContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_modal_contrasena_actualizada);

        //obteniendo objeto Pantalla
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //obteniendo ancho y alto de la pantalla
        int width = medidasVentana.widthPixels;
        int height = medidasVentana.heightPixels;
        //restringiendo el tamaño del modal
        getWindow().setLayout((int) (width*0.75), (int) (height*0.30));

        //para actualizar contraseña y volver a Login
        btnAceptarCambiarContrasena = findViewById(R.id.btnAceptarCambiarContrasena);
        btnAceptarCambiarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginModalContrasenaActualizada.this, LoginActivado.class));
            }
        });
    }
}