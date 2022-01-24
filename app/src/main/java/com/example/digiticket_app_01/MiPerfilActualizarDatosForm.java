package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MiPerfilActualizarDatosForm extends AppCompatActivity {

    private Button btnCancelar;
    //variables para el modal
    private Button btnActualizar;
    //Variables para el menu dropdown
    private AutoCompleteTextView autoCompleteTextView;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_actualizar_datos_form);


        //menu dropdown
        autoCompleteTextView = findViewById(R.id.drop_items);
        //agregando opciones al menu
        String [] opciones = {"Ciudad Universitaria","Cangallo"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.option_item_dropdown,opciones);
        //para visualizar valor seleccionado por defecto
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(),false);
        //aplicando adapter
        autoCompleteTextView.setAdapter(arrayAdapter);

        //para realizar alguna accion con el item seleccionado
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //txtView.setText((String) parent.getItemAtPosition(position));
            }
        });


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

        //boton cancelar
        btnCancelar = findViewById(R.id.btnCancelarActDatos);
        //creando listener
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //regresando a vista Mi Perfil principal
                startActivity(new Intent(MiPerfilActualizarDatosForm.this, MiPerfilPrincipal.class));
            }
        });

        //para retroceder
        btnRetroceder = findViewById(R.id.floatingActionButton3);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilActualizarDatosForm.this, MiPerfilPrincipal.class));
            }
        });
    }
}