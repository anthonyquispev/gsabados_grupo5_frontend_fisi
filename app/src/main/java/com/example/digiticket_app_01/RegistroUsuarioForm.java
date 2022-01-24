package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RegistroUsuarioForm extends AppCompatActivity {

    //Variables para el menu dropdown
    private AutoCompleteTextView autoCompleteTextView;

    //para el boton Guardar datos
    private Button btnGuardarDatos;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario_form);

        //menu dropdown
        autoCompleteTextView = findViewById(R.id.itemSedeRegistro);
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
        btnGuardarDatos = findViewById(R.id.btnGuardarDatosRegistro);
        //creando listener
        btnGuardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(RegistroUsuarioForm.this, RegistroUsuarioModalCuentaActivada.class));
            }
        });

        //para retroceder
        btnRetroceder = findViewById(R.id.floatingActionButton7);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(RegistroUsuarioForm.this, RegistroUsuarioCambiarContrasena.class));
            }
        });
    }
}