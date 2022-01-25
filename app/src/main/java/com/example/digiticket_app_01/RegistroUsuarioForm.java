package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class RegistroUsuarioForm extends AppCompatActivity {

    // inputs
    private EditText et_correoPersonal, et_telefonoPersonal, et_sedePreferencia;

    //Variables para el menu dropdown
    private AutoCompleteTextView autoCompleteTextView;

    //para el boton Guardar datos
    private Button btnGuardarDatos;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario_form);

        queue = Volley.newRequestQueue(RegistroUsuarioForm.this);

        String _id = getIntent().getStringExtra("_id");
        String nuevoPass = getIntent().getStringExtra("nuevoPass");

        et_correoPersonal = findViewById(R.id.textEditInputCorreoRegistro);
        et_telefonoPersonal = findViewById(R.id.textEditInputTelefonoRegistro);

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
//                startActivity(new Intent(RegistroUsuarioForm.this, RegistroUsuarioModalCuentaActivada.class));
                String correo_personal = et_correoPersonal.getText().toString();
                String telefono_personal = et_telefonoPersonal.getText().toString();
                String sede_preferencia = autoCompleteTextView.getText().toString();

                updateAlumno(_id, nuevoPass, correo_personal, telefono_personal, sede_preferencia);
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

    private void updateAlumno(String _id, String nuevoPass,String correo_personal, String telefono_personal, String sede_preferencia) {
        String urlAlumnos = "https://micro-usuarios.herokuapp.com/api/alumnos/" + _id;
        StringRequest request = new StringRequest(Request.Method.PUT, urlAlumnos,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Dirigiendo hacia la pantalla de Inicio
                        if (response.equals("\"Alumno actualizado\"")) {
                            Toast.makeText(RegistroUsuarioForm.this, "Cuenta activada", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistroUsuarioForm.this, PantallaInicio.class));
                        } else {
                            Toast.makeText(RegistroUsuarioForm.this, "Error", Toast.LENGTH_SHORT).show();
                        }
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
                    jsonBody.put("password", nuevoPass);
                    jsonBody.put("correo_personal", correo_personal);
                    jsonBody.put("telefono_personal", telefono_personal);
                    jsonBody.put("sede_preferencia", sede_preferencia);
                    jsonBody.put("state_account", true); // Ahora la cuenta está activada
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