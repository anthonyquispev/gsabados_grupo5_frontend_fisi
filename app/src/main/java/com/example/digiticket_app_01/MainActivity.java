package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    EditText et_cod_usuario, et_password, et_nombres;
    Button btn_login, btn_usuarios, btn_registrar;

    RequestQueue queue;

    String urlAlumnos = "https://micro-usuarios.herokuapp.com/api/alumnos";
    String urlLogin = "https://micro-usuarios.herokuapp.com/api/alumnos/login";
    String urlRegistrarAlumnos = "https://micro-usuarios.herokuapp.com/api/alumnos";

    String urlAdministradores = "https://micro-usuarios.herokuapp.com/api/administradores";

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_cod_usuario = findViewById(R.id.et_cod_usuario);
        et_password = findViewById(R.id.et_password);
        et_nombres = findViewById(R.id.et_nombres);

        btn_login = findViewById(R.id.btn_Login);
        btn_usuarios = findViewById(R.id.btn_usuarios);
        btn_registrar = findViewById(R.id.btn_registrar);

        queue = Volley.newRequestQueue(MainActivity.this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRequest(et_cod_usuario.getText().toString(), et_password.getText().toString());
            }
        });
        btn_usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuariosRequest();
            }
        });
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerRequest(et_cod_usuario.getText().toString(), et_password.getText().toString(), et_nombres.getText().toString());
            }
        });

    }

    private void usuariosRequest() {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                urlAlumnos,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(request);
    }

    private void loginRequest(String cod_usuario, String password) {
        StringRequest request = new StringRequest(Request.Method.POST, urlLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
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
                    jsonBody.put("user_id", cod_usuario);
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

    private void registerRequest(String cod_usuario, String password, String nombres) {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                urlRegistrarAlumnos,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
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
                    jsonBody.put("cod_usuario", cod_usuario);
                    jsonBody.put("password", password);
                    jsonBody.put("nombres", nombres);
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
