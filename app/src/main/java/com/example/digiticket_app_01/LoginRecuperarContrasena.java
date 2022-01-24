package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginRecuperarContrasena extends AppCompatActivity {

    private Button btnSiguienteRecuperarContrasena;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_recuperar_contrasena);

        //para actualizar la contraseña
        btnSiguienteRecuperarContrasena = findViewById(R.id.btnSiguienteRecuperarContrasena);
        btnSiguienteRecuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginRecuperarContrasena.this, LoginCambiarContrasena.class));
            }
        });

        //para retroceder
        btnRetroceder = findViewById(R.id.floatingActionButton8);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(LoginRecuperarContrasena.this, LoginActivado.class));
            }
        });
    }
}