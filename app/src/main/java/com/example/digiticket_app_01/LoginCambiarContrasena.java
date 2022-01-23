package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginCambiarContrasena extends AppCompatActivity {

    private Button btnGuardarContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cambiar_contrasena);

        //para guardar la contraseña actualizada
        btnGuardarContrasena = findViewById(R.id.btnGuardarContrasena);
        btnGuardarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginCambiarContrasena.this, LoginModalContrasenaActualizada.class));
            }
        });
    }
}