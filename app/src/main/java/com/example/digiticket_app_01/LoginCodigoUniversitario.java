package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginCodigoUniversitario extends AppCompatActivity {

    private Button btnSiguienteLoginCod;
    private TextView btnActivarCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_codigo_universitario);

        //boton siguiente
        btnSiguienteLoginCod = findViewById(R.id.btnSiguienteLoginCod);
        //creando listener
        btnSiguienteLoginCod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando hacia login activado
                startActivity(new Intent(LoginCodigoUniversitario.this, LoginActivado.class));
            }
        });

        //activar cuenta
        btnActivarCuenta = findViewById(R.id.enlaceActivarCuenta);
        //creando listener
        btnActivarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando hacia login activado
                startActivity(new Intent(LoginCodigoUniversitario.this, LoginModalUsuarioDesconocido.class));
            }
        });
    }
}