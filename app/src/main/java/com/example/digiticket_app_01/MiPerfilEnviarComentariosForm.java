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

public class MiPerfilEnviarComentariosForm extends AppCompatActivity {

    private Button btnEnviar;
    //Variables para el menu dropdown
    private AutoCompleteTextView autoCompleteTextView;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_enviar_comentarios_form);

        //menu dropdown
        autoCompleteTextView = findViewById(R.id.comentario_item);
        //agregando opciones al menu
        String [] opciones = {"Sugerencia","Reclamo"};
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


        //para el boton enviar al modal
        btnEnviar = findViewById(R.id.btnEnviarComentarioForm);
        //creando listener
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilEnviarComentariosForm.this, MiPerfilEnviarComentariosModal.class));
            }
        });

        //para retroceder
        btnRetroceder = findViewById(R.id.floatingActionButton4);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(MiPerfilEnviarComentariosForm.this, MiPerfilPrincipal.class));
            }
        });
    }
}