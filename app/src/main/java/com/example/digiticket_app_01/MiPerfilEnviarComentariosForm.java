package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.digiticket_app_01.configuracion.Sistema;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MiPerfilEnviarComentariosForm extends AppCompatActivity {
    RequestQueue queue;

    private TextView txt_comentario;
    private TextView txt_tipo_comentario;

    String contenido_comentario = "";
    String tipo_comentario = "";
    String user_id = Sistema.user_id;

    private Button btnEnviar;
    //Variables para el menu dropdown
    private AutoCompleteTextView autoCompleteTextView;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_enviar_comentarios_form);
        queue = Volley.newRequestQueue(MiPerfilEnviarComentariosForm.this);

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

        txt_comentario = findViewById(R.id.textEditInputComentario);
        txt_tipo_comentario = findViewById(R.id.comentario_item);

        //para el boton enviar al modal
        btnEnviar = findViewById(R.id.btnEnviarComentarioForm);
        //creando listener
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MiPerfilEnviarComentariosForm.this, "Fuera de Envío Comentario API", Toast.LENGTH_SHORT).show();
                enviarComentario(txt_comentario.getText().toString(),user_id,txt_tipo_comentario.getText().toString());

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

    public void enviarComentario(String comentario, String user_id, String tipo_comentario){
        Toast.makeText(MiPerfilEnviarComentariosForm.this, "Dentro de envío comentario API", Toast.LENGTH_SHORT).show();
        String urlLogin = "http://alumnos-comentarios.herokuapp.com/api/comentarios";
        StringRequest request = new StringRequest(Request.Method.POST, urlLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MiPerfilEnviarComentariosForm.this, "Comentario Enviado Correctamente", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        ) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("user_id", user_id);
                    jsonBody.put("tipo", tipo_comentario);
                    jsonBody.put("comentario",comentario);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final String requestBody = jsonBody.toString();
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };
        queue.add(request);
    }
}