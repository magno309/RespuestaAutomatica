package com.example.respuestaautomatica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.respuestaautomatica.Servicios.CallReceiver;

public class MainActivity extends AppCompatActivity {

    TextView txtTelefono, txtMensaje;
    Button btnGuardar;

    public static String telefono, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTelefono = findViewById(R.id.txtTelefonoActual);
        txtMensaje = findViewById(R.id.txtMensaje);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(v -> {
            //Aquí va el código
            telefono = txtTelefono.getText().toString();
            mensaje = txtMensaje.getText().toString();
            CallReceiver callReceiver = new CallReceiver();
            Toast.makeText(this, "Datos guardados!", Toast.LENGTH_SHORT).show();
        });
    }
}

// Referencias
/*
* https://programacion.net/articulo/enviar-_recibir_y_ver_el_historial_de_sms_con_android_1089
* https://stackoverflow.com/questions/15563921/how-to-detect-incoming-calls-in-an-android-device
*
* */