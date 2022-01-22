package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MiPerfilHistorialTickets extends AppCompatActivity {

    private ImageView btnDetalle1;
    private ImageView btnDetalle2;
    private ImageView btnDetalle3;
    private ImageView btnDetalle4;
    private ImageView btnDetalle5;
    //para regresar a la vista principal Mi Perfil
    private FloatingActionButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_historial_tickets);


        //linkeando el boton para ver Detalle 1
        btnDetalle1 = findViewById(R.id.btnDetalle1);
        //creando listener
        btnDetalle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el nuevo modal
                startActivity(new Intent(MiPerfilHistorialTickets.this, MiPerfilHistorialTicketsDetalle.class));
            }
        });

        //linkeando el boton para ver Detalle 2
        btnDetalle2 = findViewById(R.id.btnDetalle2);
        //creando listener
        btnDetalle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el nuevo modal
                startActivity(new Intent(MiPerfilHistorialTickets.this, MiPerfilHistorialTicketsDetalle.class));
            }
        });

        //linkeando el boton para ver Detalle 3
        btnDetalle3 = findViewById(R.id.btnDetalle3);
        //creando listener
        btnDetalle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el nuevo modal
                startActivity(new Intent(MiPerfilHistorialTickets.this, MiPerfilHistorialTicketsDetalle.class));
            }
        });

        //linkeando el boton para ver Detalle 4
        btnDetalle4 = findViewById(R.id.btnDetalle4);
        //creando listener
        btnDetalle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el nuevo modal
                startActivity(new Intent(MiPerfilHistorialTickets.this, MiPerfilHistorialTicketsDetalle.class));
            }
        });

        //linkeando el boton para ver Detalle 5
        btnDetalle5 = findViewById(R.id.btnDetalle5);
        //creando listener
        btnDetalle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el nuevo modal
                startActivity(new Intent(MiPerfilHistorialTickets.this, MiPerfilHistorialTicketsDetalle.class));
            }
        });

        //linkeando el boton para regresar a Mi Perfil principal
        btnBack = findViewById(R.id.floatingActionButton6);
        //creando listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el nuevo modal
                startActivity(new Intent(MiPerfilHistorialTickets.this, MiPerfilPrincipal.class));
            }
        });
    }
}