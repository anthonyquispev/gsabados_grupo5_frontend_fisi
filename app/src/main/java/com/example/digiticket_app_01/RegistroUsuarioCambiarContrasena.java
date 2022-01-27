package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.example.digiticket_app_01.configuracion.Sistema;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class RegistroUsuarioCambiarContrasena extends AppCompatActivity {

    private Button btnSiguiente;
    private FloatingActionButton btnCancelarRegistro;

    private EditText et_codigoUniversitario, et_contraseñaCorreoInstitucional, et_nuevoPass, et_confirmarPass;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario_cambiar_contrasena);

        queue = Volley.newRequestQueue(RegistroUsuarioCambiarContrasena.this);
        String _id = Sistema._id;

        et_codigoUniversitario = findViewById(R.id.textEditInputCodigoRegistroCambiarContrasena);
        et_contraseñaCorreoInstitucional = findViewById(R.id.textEditInputContrasenaInsRegistroCambiarContrasena);
        et_nuevoPass = findViewById(R.id.textEditInputNuevaContrasena);
        et_confirmarPass = findViewById(R.id.textEditInputRepetirContrasena);

        //navegando hacia el siguiente formulario de registro
        btnSiguiente = findViewById(R.id.btnSiguienteCambiarContrasena);
        //creando listener
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando al formulario de registro
//                startActivity(new Intent(RegistroUsuarioCambiarContrasena.this, RegistroUsuarioForm.class));
                validarDatos(_id,
                        et_codigoUniversitario.getText().toString(),
                        et_contraseñaCorreoInstitucional.getText().toString(),
                        et_nuevoPass.getText().toString(),
                        et_confirmarPass.getText().toString());
            }
        });

        //navegando hacia el formulario de inicio (retroceder)
        btnCancelarRegistro = findViewById(R.id.fltBtnCancelarRegistro);
        //creando listener
        btnCancelarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navegando al formulario de registro
                startActivity(new Intent(RegistroUsuarioCambiarContrasena.this, RegistroUsuarioModalCancelarRegistro.class));
            }
        });
    }

    private void validarDatos(String _id, String user_id, String password, String nuevoPass, String confirmarPass) {
        String urlLogin = "https://micro-usuarios.herokuapp.com/api/alumnos/login";
        StringRequest request = new StringRequest(Request.Method.POST, urlLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // CREDENCIALES INCORRECTAS
                        if (response.equals("\"Credenciales incorrectas\"")) {
                            Toast.makeText(RegistroUsuarioCambiarContrasena.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                        }
                        // CREDENCIALES CORRECTAS, ahora se debe confirmar la nueva password
                        else {
                            if (nuevoPass.equals(confirmarPass)) {
                                Intent i = new Intent(RegistroUsuarioCambiarContrasena.this, RegistroUsuarioForm.class);
                                i.putExtra("user_id", user_id);
                                i.putExtra("nuevoPass", nuevoPass);
                                startActivity(i);
                            } else {
                                Toast.makeText(RegistroUsuarioCambiarContrasena.this, "Contraseñas diferentes", Toast.LENGTH_SHORT).show();
                            }
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