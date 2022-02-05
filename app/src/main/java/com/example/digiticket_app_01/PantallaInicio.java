package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.digiticket_app_01.configuracion.Sistema;
import com.google.firebase.analytics.FirebaseAnalytics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PantallaInicio extends AppCompatActivity {

    //Para implementar Analytics
    private FirebaseAnalytics mFirebaseAnalytics;

    //para navegar a los modulos
    private ImageButton btnReservar;
    private ImageView btnVerTicket;
    private ImageView btnMiPerfil;

    //ver info nutricional
    private ImageView btnVerDetalle1;
    private ImageView btnVerDetalle2;
    private ImageView btnVerDetalle3;
    private ImageView btnVerDetalle4;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(PantallaInicio.this);

        setContentView(R.layout.activity_pantalla_inicio);
        pintarCantidadTickets();
        //Ver informacion nutricional 1
        btnVerDetalle1 = findViewById(R.id.btnVerDetallesHome1);
        //creando listener
        btnVerDetalle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Probando envío de eventos
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                bundle.putString("CODIGO_ALUMNO", "186666666");
                mFirebaseAnalytics.logEvent("ABRIR_INFO_NUTRICIONAL_ENTRADA", bundle);
                //abriendo modal de Inf. nutricional
                startActivity(new Intent(PantallaInicio.this, PantallaInicioModalInfoNutricional.class));
            }
        });

        //Ver informacion nutricional 2
        btnVerDetalle2 = findViewById(R.id.btnVerDetallesHome2);
        //creando listener
        btnVerDetalle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("ABRIR_INFO_NUTRICIONAL_SEGUNDO", bundle);
                //abriendo modal de Inf. nutricional
                startActivity(new Intent(PantallaInicio.this, PantallaInicioModalInfoNutricional.class));
            }
        });

        //Ver informacion nutricional 3
        btnVerDetalle3 = findViewById(R.id.btnVerDetallesHome3);
        //creando listener
        btnVerDetalle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("ABRIR_INFO_NUTRICIONAL_POSTRE", bundle);
                //abriendo modal de Inf. nutricional
                startActivity(new Intent(PantallaInicio.this, PantallaInicioModalInfoNutricional.class));
            }
        });

        //Ver informacion nutricional 4
        btnVerDetalle4 = findViewById(R.id.btnVerDetallesHome4);
        //creando listener
        btnVerDetalle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("ABRIR_INFO_NUTRICIONAL_BEBIDA", bundle);
                //abriendo modal de Inf. nutricional
                startActivity(new Intent(PantallaInicio.this, PantallaInicioModalInfoNutricional.class));
            }
        });

        //Reservar ticket
        btnReservar = findViewById(R.id.btnReservarHome);
        //creando listener
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("CLICK_OPCION_RESERVAR", bundle);

                if (Sistema.flag_reserva_enable){
                    //navegando a Reservar Ticket
                    startActivity(new Intent(PantallaInicio.this, ReservaEscogerSede.class));
                }else{
                    Toast.makeText(PantallaInicio.this, "Usted ya tiene una reserva activa", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Ver ticket
        btnVerTicket = findViewById(R.id.btnVerTicketHome);
        //creando listener
        btnVerTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("CLICK_OPCION_VER_TICKET", bundle);
                //navegando a Ver Ticket
                startActivity(new Intent(PantallaInicio.this, ReservaMostrarTicket.class));
            }
        });

        //Mi Perfil
        btnMiPerfil = findViewById(R.id.btnMiPerfilHome);
        //creando listener
        btnMiPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("CODIGO_ALUMNO", Sistema.user_id.toString());
                mFirebaseAnalytics.logEvent("CLICK_OPCION_MI_PERFIL", bundle);
                //navegando a Mi Perfil
                startActivity(new Intent(PantallaInicio.this, MiPerfilPrincipal.class));
            }
        });
    }

    private void pintarCantidadTickets() {
        String url = "https://micro-reservas.herokuapp.com/api/turnos";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject jsonObject1 = new JSONObject(response.get(0).toString());
                            Sistema.cantidad_ticket1 = jsonObject1.getString("cantidad_raciones");
                            JSONObject jsonObject2 = new JSONObject(response.get(1).toString());
                            Sistema.cantidad_ticket2 = jsonObject2.getString("cantidad_raciones");
                            JSONObject jsonObject3 = new JSONObject(response.get(2).toString());
                            Sistema.cantidad_ticket3 = jsonObject3.getString("cantidad_raciones");
                            JSONObject jsonObject4 = new JSONObject(response.get(3).toString());
                            Sistema.cantidad_ticket4 = jsonObject4.getString("cantidad_raciones");
                            JSONObject jsonObject5 = new JSONObject(response.get(4).toString());
                            Sistema.cantidad_ticket5 = jsonObject5.getString("cantidad_raciones");

                        } catch (JSONException e) {
                            e.printStackTrace();
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