package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaInicio extends AppCompatActivity {
    private ImageButton btnVerDetalle;
    private ImageButton btnReservar;
    private ImageView btnVerTicket;
    private ImageView btnMiPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        //Ver informacion nutricional
        btnVerDetalle = findViewById(R.id.btnVerDetalle);
        //creando listener
        btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo modal de Inf. nutricional
                startActivity(new Intent(PantallaInicio.this, PantallaInicioModalInfoNutricional.class));
            }
        });

        //Reservar ticket
        btnReservar = findViewById(R.id.btnReservarHome);
        //creando listener
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando a Reservar Ticket
                startActivity(new Intent(PantallaInicio.this, ReservaEscogerSede.class));
            }
        });

        //Ver ticket
        btnVerTicket = findViewById(R.id.btnVerTicketHome);
        //creando listener
        btnVerTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando a Ver Ticket
                startActivity(new Intent(PantallaInicio.this, ReservaMostrarTicket.class));
            }
        });

        //Mi Perfil
        btnMiPerfil = findViewById(R.id.btnMiPerfilHome);
        //creando listener
        btnMiPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando a Mi Perfil
                startActivity(new Intent(PantallaInicio.this, MiPerfilPrincipal.class));
            }
        });
    }
}