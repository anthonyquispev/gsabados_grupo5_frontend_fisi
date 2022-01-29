package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class ReservaResumenReserva extends AppCompatActivity {

    // Variables para mostrar en el resumen
    private TextView tv_nombreCompleto;
    private TextView tv_codigoUniversitario;
    private TextView tv_servicio;
    private TextView tv_sede;
    private TextView tv_turno_horario;

    //variables para el modal
    private Button btnReservar;

    //para retroceder
    private FloatingActionButton btnRetroceder;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_resumen_reserva);
        queue = Volley.newRequestQueue(ReservaResumenReserva.this);

        tv_nombreCompleto = findViewById(R.id.txtNombreApRMostrar);
        tv_codigoUniversitario = findViewById(R.id.txtCodigoRMostrar);
        tv_servicio = findViewById(R.id.txtServicioRMostrar);
        tv_sede = findViewById(R.id.txtSedeRMostrar);
        tv_turno_horario = findViewById(R.id.txtTurnoRMostrar);

        // Lectura de Intent
        String user_id = Sistema.user_id;
        String sede = getIntent().getStringExtra("sede");
        String nivel = getIntent().getStringExtra("nivel");
        String turno_id = getIntent().getStringExtra("turno_id");
        String turno_numero = getIntent().getStringExtra("turno_numero");
        String turno_horario = getIntent().getStringExtra("turno_horario");

        // Llenado de datos
        tv_nombreCompleto.setText(Sistema.nombres + " " + Sistema.apellidos);
        tv_codigoUniversitario.setText(user_id);
        tv_servicio.setText(Sistema.servicio_nombre);
        tv_sede.setText(sede);
        tv_turno_horario.setText(turno_numero + " / " + turno_horario);


        JSONObject jsonObjectcomidas = new JSONObject();
        try {
            if (getIntent().getStringExtra("entrada") != null) {
                jsonObjectcomidas.put("entrada", getIntent().getStringExtra("entrada"));
            }
            if (getIntent().getStringExtra("segundo") != null) {
                jsonObjectcomidas.put("segundo", getIntent().getStringExtra("segundo"));
            }
            if (getIntent().getStringExtra("postre") != null) {
                jsonObjectcomidas.put("postre", getIntent().getStringExtra("postre"));
            }
            if (getIntent().getStringExtra("refresco") != null) {
                jsonObjectcomidas.put("refresco", getIntent().getStringExtra("refresco"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //abriendo modal para confirmar reserva
        btnReservar = findViewById(R.id.btnInicioFinReserva);
        //creando listener
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
//                startActivity(new Intent(ReservaResumenReserva.this, ReservaModalConfirmacion.class));
                registrarReserva(user_id, Sistema.servicio_id, sede, nivel, turno_id, jsonObjectcomidas);
            }
        });

        //para retroceder
        btnRetroceder = findViewById(R.id.floatingActionButton2);
        //creando listener
        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iniciando el modal
                startActivity(new Intent(ReservaResumenReserva.this, ReservaEscogerPlato.class));
            }
        });
    }

    private void registrarReserva(String user_id, String servicio_id, String sede, String nivel, String turno_id, JSONObject jsonObjectcomidas) {
        String urlRegistrarReservas = "https://micro-reservas.herokuapp.com/api/reservas";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                urlRegistrarReservas,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ReservaResumenReserva.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ReservaResumenReserva.this, PantallaInicio.class));
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
                    jsonBody.put("servicio_id", servicio_id);
                    jsonBody.put("sede", sede);
                    jsonBody.put("nivel", nivel);
                    jsonBody.put("turno_id", turno_id);
                    jsonBody.put("comidas", jsonObjectcomidas);
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