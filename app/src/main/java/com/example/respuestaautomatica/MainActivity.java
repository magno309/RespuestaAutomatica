package com.example.respuestaautomatica;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.respuestaautomatica.Servicios.CallReceiver;

public class MainActivity extends AppCompatActivity {

    TextView txtTelefono, txtMensaje;
    Button btnGuardar;

    public String telefono, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        telefono = sharedPref.getString(getResources().getString(R.string.KEY_TELEFONO), "");
        mensaje = sharedPref.getString(getResources().getString(R.string.KEY_MENSAJE), "");
        txtTelefono = findViewById(R.id.txtTelefonoActual);
        txtMensaje = findViewById(R.id.txtMensaje);
        btnGuardar = findViewById(R.id.btnGuardar);
        txtMensaje.setText(mensaje);
        txtTelefono.setText(telefono);
        //obtenerPermisos();
        btnGuardar.setOnClickListener(v -> {
            //Aquí va el código
            if(!txtMensaje.getText().toString().equals("")){
                if(!txtTelefono.getText().toString().equals("")){
                    editor.putString(getString(R.string.KEY_TELEFONO), txtTelefono.getText().toString());
                    editor.putString(getString(R.string.KEY_MENSAJE), txtMensaje.getText().toString());
                    editor.commit();
                    Toast.makeText(this, "Datos guardados!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Ingrese un mensaje!", Toast.LENGTH_SHORT).show();
                    txtMensaje.requestFocus();
                }
            }else {
                Toast.makeText(this, "Ingrese un número de teléfono!", Toast.LENGTH_SHORT).show();
                txtTelefono.requestFocus();
            }
        });
    }

    /*@RequiresApi(api = Build.VERSION_CODES.M)
    private void obtenerPermisos() {
        if (getApplicationContext().checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission has not been granted, therefore prompt the user to grant permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }

        if (getApplicationContext().checkSelfPermission(Manifest.permission.PROCESS_OUTGOING_CALLS)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission has not been granted, therefore prompt the user to grant permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},
                    MY_PERMISSIONS_REQUEST_PROCESS_OUTGOING_CALLS);
        }
    }*/
}

// Referencias
/*
* https://programacion.net/articulo/enviar-_recibir_y_ver_el_historial_de_sms_con_android_1089
* https://stackoverflow.com/questions/15563921/how-to-detect-incoming-calls-in-an-android-device
*
* */