package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RegistroUsuarioCambiarContrasena extends AppCompatActivity {

    private Button btnSiguiente;
    private FloatingActionButton btnCancelarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario_cambiar_contrasena);

        //navegando hacia el siguiente formulario de registro
        btnSiguiente = findViewById(R.id.btnSiguienteCambiarContrasena);
        //creando listener
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando al formulario de registro
                startActivity(new Intent(RegistroUsuarioCambiarContrasena.this, RegistroUsuarioForm.class));
            }
        });

        //navegando hacia el formulario de inicio (retroceder)
        btnCancelarRegistro = findViewById(R.id.fltBtnCancelarRegistro);
        //creando listener
        btnCancelarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando al formulario de registro
                startActivity(new Intent(RegistroUsuarioCambiarContrasena.this, RegistroUsuarioModalCancelarRegistro.class));
            }
        });
    }
}