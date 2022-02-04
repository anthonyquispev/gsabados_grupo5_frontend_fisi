package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digiticket_app_01.configuracion.Sistema;
import com.google.firebase.analytics.FirebaseAnalytics;

public class PantallaInicio extends AppCompatActivity {

    //Para implementar Analytics
    private FirebaseAnalytics mFirebaseAnalytics;

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
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        //Ver informacion nutricional 1
        btnVerDetalle1 = findViewById(R.id.btnVerDetallesHome1);
        //creando listener
        btnVerDetalle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Probando envío de eventos
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                bundle.putString("CODIGO_ALUMNO", "186666666");
                mFirebaseAnalytics.logEvent("ABRIR_INFO_NUTRICIONAL_ENTRADA", bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("ABRIR_INFO_NUTRICIONAL_SEGUNDO", bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("ABRIR_INFO_NUTRICIONAL_POSTRE", bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("ABRIR_INFO_NUTRICIONAL_BEBIDA", bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("CLICK_OPCION_RESERVAR", bundle);

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
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("CLICK_OPCION_VER_TICKET", bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("CLICK_OPCION_MI_PERFIL", bundle);
                //navegando a Mi Perfil
                startActivity(new Intent(PantallaInicio.this, MiPerfilPrincipal.class));
            }
        });
    }
}