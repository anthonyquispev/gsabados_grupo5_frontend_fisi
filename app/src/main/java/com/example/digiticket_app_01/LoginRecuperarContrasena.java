package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginRecuperarContrasena extends AppCompatActivity {

    private Button btnSiguienteRecuperarContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_recuperar_contrasena);

        btnSiguienteRecuperarContrasena = findViewById(R.id.btnSiguienteRecuperarContrasena);
        btnSiguienteRecuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginRecuperarContrasena.this, LoginCambiarContrasena.class));
            }
        });
    }
}