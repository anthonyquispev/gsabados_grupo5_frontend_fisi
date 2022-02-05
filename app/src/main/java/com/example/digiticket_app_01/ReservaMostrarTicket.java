package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digiticket_app_01.configuracion.Sistema;

public class ReservaMostrarTicket extends AppCompatActivity {

    private Button btnIrInicio;

    private TextView tv_nombreCompleto;
    private TextView tv_codigoUniversitario;
    private TextView tv_servicio;
    private TextView tv_sede;
    private TextView tv_turno_horario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_mostrar_ticket);

        tv_nombreCompleto = findViewById(R.id.txtNombreApRMostrar);
        tv_codigoUniversitario = findViewById(R.id.txtCodigoRMostrar);
        tv_servicio = findViewById(R.id.txtServicioRMostrar);
        tv_sede = findViewById(R.id.txtSedeRMostrar);
        tv_turno_horario = findViewById(R.id.txtTurnoRMostrar);

        tv_nombreCompleto.setText(Sistema.nombres + " " + Sistema.apellidos);
        tv_codigoUniversitario.setText(Sistema.user_id_ticket);
        tv_servicio.setText(Sistema.servicio_nombre);
        tv_sede.setText(Sistema.sede_ticket);
        tv_turno_horario.setText(Sistema.turno_horario_ticket);

        //linkeando el (boton) con activity Pantalla Inicio
        btnIrInicio = findViewById(R.id.btnInicioFinReserva);
        //creando listener
        btnIrInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abriendo activity Home
                startActivity(new Intent(ReservaMostrarTicket.this, PantallaInicio.class));
            }
        });
    }
}