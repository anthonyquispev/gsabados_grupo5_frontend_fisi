package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaInicio extends AppCompatActivity {

    //para navegar a los modulos
    private ImageButton btnReservar;
    private ImageView btnVerTicket;
    private ImageView btnMiPerfil;

    //ver info nutricional
    private ImageView btnVerDetalle1;
    private ImageView btnVerDetalle2;
    private ImageView btnVerDetalle3;
    private ImageView btnVerDetalle4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        //Ver informacion nutricional 1
        btnVerDetalle1 = findViewById(R.id.btnVerDetallesHome1);
        //creando listener
        btnVerDetalle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo modal de Inf. nutricional
                startActivity(new Intent(PantallaInicio.this, PantallaInicioModalInfoNutricional.class));
            }
        });

        //Ver informacion nutricional 2
        btnVerDetalle2 = findViewById(R.id.btnVerDetallesHome2);
        //creando listener
        btnVerDetalle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo modal de Inf. nutricional
                startActivity(new Intent(PantallaInicio.this, PantallaInicioModalInfoNutricional.class));
            }
        });

        //Ver informacion nutricional 3
        btnVerDetalle3 = findViewById(R.id.btnVerDetallesHome3);
        //creando listener
        btnVerDetalle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo modal de Inf. nutricional
                startActivity(new Intent(PantallaInicio.this, PantallaInicioModalInfoNutricional.class));
            }
        });

        //Ver informacion nutricional 4
        btnVerDetalle4 = findViewById(R.id.btnVerDetallesHome4);
        //creando listener
        btnVerDetalle4.setOnClickListener(new View.OnClickListener() {
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