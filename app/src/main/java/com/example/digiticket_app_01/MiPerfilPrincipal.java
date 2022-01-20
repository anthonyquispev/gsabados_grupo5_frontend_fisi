package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MiPerfilPrincipal extends AppCompatActivity {

    //variables para el modal
    private TextView txtCerrarSesion;
    private TextView txtCancelarReserva;
    private TextView txtActualizarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_principal);

        //linkeando el modal con el boton Cancelar Reserva
        txtCancelarReserva = findViewById(R.id.txtCancelarReserva);
        //creando listener
        txtCancelarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilModalCancelar.class));
            }
        });


        //linkeando el modal con el boton Cerrar Sesion
        txtCerrarSesion = findViewById(R.id.txtCerrarSesion);
        //creando listener
        txtCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilModalCerrarSesion.class));
            }
        });

        //linkeando el modal con el boton Actualizar datos
        txtActualizarDatos = findViewById(R.id.txtActualizarDatosMP);
        //creando listener
        txtActualizarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilActualizarDatosForm.class));
            }
        });
    }
}