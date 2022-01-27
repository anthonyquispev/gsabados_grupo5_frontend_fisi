package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.digiticket_app_01.configuracion.Sistema;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class LoginActivado extends AppCompatActivity {

    private Button btnIngresar;
    private TextView btnRecuperarContrasena;
    private TextView txtxIngresarCuentaDiferente;
    private TextView btnI;
    private EditText et_password;
    private TextView nombresApellidos;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activado);
        queue = Volley.newRequestQueue(LoginActivado.this);

        String user_id = getIntent().getStringExtra("user_id");
        Toast.makeText(LoginActivado.this, user_id, Toast.LENGTH_SHORT).show();

        nombresApellidos = findViewById(R.id.txtNombreUsuarioLoginActivado);
        nombresApellidos.setText(Sistema.nombres + " " + Sistema.apellidos);
        //para ingresar a la app
        et_password = findViewById(R.id.textEditInputContraseñaLoginActivado);
        btnIngresar = findViewById(R.id.btnIngresarLoginActivado);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRequest(user_id, et_password.getText().toString());
            }
        });

        //para recuperar contraseña
        btnRecuperarContrasena = findViewById(R.id.txtOlvidasteContrasena);
        btnRecuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivado.this, LoginRecuperarContrasena.class));
            }
        });

        //para ingresar con otra cuenta
        txtxIngresarCuentaDiferente = findViewById(R.id.txtxIngresarCuentaDiferente);
        txtxIngresarCuentaDiferente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivado.this, LoginCodigoUniversitario.class));
            }
        });
    }

    private void loginRequest(String user_id, String password) {
        String urlLogin = "https://micro-usuarios.herokuapp.com/api/alumnos/login";
        StringRequest request = new StringRequest(Request.Method.POST, urlLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // PASSWORD CORRECTO
                        if (response.equals("\"Credenciales correctas\"")) {
                            Intent i = new Intent(LoginActivado.this, PantallaInicio.class);
                            i.putExtra("user_id", user_id);
                            startActivity(i);
                        }
                        // PASSWORD INCORRECTO
                        else {
                            Toast.makeText(LoginActivado.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
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
                    jsonBody.put("user_id", user_id);
                    jsonBody.put("password", password);
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