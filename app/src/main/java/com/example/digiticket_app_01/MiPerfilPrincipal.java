package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MiPerfilPrincipal extends AppCompatActivity {

    //variables para submodulos
    private TextView txtCerrarSesion;
    private TextView txtCancelarReserva;
    private TextView txtActualizarDatos;
    private TextView txtEnviarComentarios;
    private TextView txtProgramacionSemanal;
    private TextView txtHistorialTickets;

    //para regresar a la pagina principal
    private ImageView btnVolverInicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_principal);

        //Ir a Cancelar Reserva
        txtCancelarReserva = findViewById(R.id.txtCancelarReserva);
        //creando listener
        txtCancelarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilModalCancelar.class));
            }
        });


        //Ir a Cerrar Sesion
        txtCerrarSesion = findViewById(R.id.txtCerrarSesion);
        //creando listener
        txtCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilModalCerrarSesion.class));
            }
        });

        //Ir a Actualizar datos
        txtActualizarDatos = findViewById(R.id.txtActualizarDatosMP);
        //creando listener
        txtActualizarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilActualizarDatosForm.class));
            }
        });

        //Ir a Enviar comentarios
        txtEnviarComentarios = findViewById(R.id.txtEnviarComentariosMP);
        //creando listener
        txtEnviarComentarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilEnviarComentariosForm.class));
            }
        });

        //Ir a Programacion semanal
        txtProgramacionSemanal = findViewById(R.id.txtProgramacionMP);
        //creando listener
        txtProgramacionSemanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilVerHorarioSemanal.class));
            }
        });

        //Ir a Historial de tickets
        txtHistorialTickets = findViewById(R.id.txtHistorialTicketsMP);
        //creando listener
        txtHistorialTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, MiPerfilHistorialTickets.class));
            }
        });

        //Volver a Inicio
        btnVolverInicio = findViewById(R.id.btnVolverInicioMP);
        //creando listener
        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilPrincipal.this, PantallaInicio.class));
            }
        });
    }
}