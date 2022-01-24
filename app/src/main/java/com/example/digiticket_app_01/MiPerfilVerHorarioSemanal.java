package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MiPerfilVerHorarioSemanal extends AppCompatActivity {

    private FloatingActionButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_ver_horario_semanal);

        //linkeando el boton para regresar a Mi Perfil principal
        btnBack = findViewById(R.id.floatingActionButton5);
        //creando listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el nuevo modal
                startActivity(new Intent(MiPerfilVerHorarioSemanal.this, MiPerfilPrincipal.class));
            }
        });
    }
}