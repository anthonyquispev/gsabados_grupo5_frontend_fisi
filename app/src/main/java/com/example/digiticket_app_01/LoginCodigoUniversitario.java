package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class LoginCodigoUniversitario extends AppCompatActivity {

    RequestQueue queue;

    String urlAlumnos = "https://micro-usuarios.herokuapp.com/api/alumnos";
    String urlLogin = "https://micro-usuarios.herokuapp.com/api/alumnos/login";

    private Button btnSiguienteLoginCod;
    private TextView btnActivarCuenta;
    private EditText et_inputCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_codigo_universitario);
        queue = Volley.newRequestQueue(LoginCodigoUniversitario.this);
        et_inputCodigo = findViewById(R.id.textEditInputCodigo);
        //boton siguiente
        btnSiguienteLoginCod = findViewById(R.id.btnSiguienteLoginCod);
        //creando listener
        btnSiguienteLoginCod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando hacia login activado
                getAlumno(et_inputCodigo.getText().toString());
            }
        });

        //activar cuenta
        btnActivarCuenta = findViewById(R.id.enlaceActivarCuenta);
        //creando listener
        btnActivarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando hacia login activado
//                startActivity(new Intent(LoginCodigoUniversitario.this, LoginModalUsuarioDesconocido.class));
            }
        });
    }

    private void getAlumno(String user_id) {
        String url = "https://micro-usuarios.herokuapp.com/api/alumnos/" + user_id;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // EL USUARIO NO EXISTE
                        if (response.length() == 0) {
                            Toast.makeText(LoginCodigoUniversitario.this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                        }
                        // EL USUARIO EXISTE
                        else {
                            // Se verifica si es que la cuenta está activada o no
                            try {
                                JSONObject jsonObject = new JSONObject(response.get(0).toString());
                                String _id = jsonObject.getString("_id");
                                boolean state_account = Boolean.parseBoolean(jsonObject.getString("state_account"));
                                // Cuenta activada
                                if (state_account) {
                                    Intent i = new Intent(LoginCodigoUniversitario.this, LoginActivado.class);
                                    i.putExtra("user_id", user_id);
                                    startActivity(i);
                                }
                                // Cuenta no activada
                                else {
                                    Intent i = new Intent(LoginCodigoUniversitario.this, RegistroUsuarioCambiarContrasena.class);
                                    i.putExtra("_id", _id);
                                    startActivity(i);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );
        queue.add(jsonArrayRequest);
    }

}