package com.example.digiticket_app_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReservaMostrarTicket extends AppCompatActivity {

    private Button btnIrInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_mostrar_ticket);

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