package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivado extends AppCompatActivity {

    private Button btnIngresar;
    private TextView btnRecuperarContrasena;
    private TextView txtxIngresarCuentaDiferente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activado);

        //para ingresar a la app
        btnIngresar = findViewById(R.id.btnIngresarLoginActivado);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivado.this, PantallaInicio.class));
            }
        });

        //para recuperar contraseña
        btnRecuperarContrasena = findViewById(R.id.txtOlvidasteContrasena);
        btnRecuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivado.this, LoginRecuperarContrasena.class));
            }
        });

        //para ingresar con otra cuenta
        txtxIngresarCuentaDiferente = findViewById(R.id.txtxIngresarCuentaDiferente);
        txtxIngresarCuentaDiferente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivado.this, LoginCodigoUniversitario.class));
            }
        });
    }
}