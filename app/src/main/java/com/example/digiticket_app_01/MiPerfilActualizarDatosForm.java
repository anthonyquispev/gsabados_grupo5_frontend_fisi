package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class MiPerfilActualizarDatosForm extends AppCompatActivity {

    //variables para el modal
    private Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_actualizar_datos_form);

        //linkeando el modal con el boton
        btnActualizar = findViewById(R.id.btnAcualizarDatos);
        //creando listener
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilActualizarDatosForm.this, MiPerfilActualizarDatosModal.class));
            }
        });
    }
}