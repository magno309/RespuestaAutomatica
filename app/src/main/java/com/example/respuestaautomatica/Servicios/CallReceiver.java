package com.example.respuestaautomatica.Servicios;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.example.respuestaautomatica.MainActivity;
import com.example.respuestaautomatica.R;

import java.util.Date;

public class CallReceiver extends PhoneCallReceiver {

    private SharedPreferences sharedPreferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        //Log.d("ICRA", "Entra a onReceive heredado");
    }

    @Override
    protected void onIncomingCallReceived(Context ctx, String number, Date start) {
        Log.d("ICRA", "Llamada recibida: " + number);
        sharedPreferences = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String telefono = sharedPreferences.getString(ctx.getResources().getString(R.string.KEY_TELEFONO), "");
        String mensaje = sharedPreferences.getString(ctx.getResources().getString(R.string.KEY_MENSAJE), "");
        //Log.d("ICRA", "Telefono: " + telefono);
        //Log.d("ICRA", "Mensaje: " + mensaje);
        if(number.equals(telefono)){
            try{
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(telefono, null, mensaje, null, null);
                Toast.makeText(ctx, "Mensaje enviado!", Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Log.d("ICRA", e.getMessage());
            }
        }
    }

    @Override
    protected void onIncomingCallAnswered(Context ctx, String number, Date start) {

    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {

    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {

    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {

    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        //Log.d("ICRA", "Llamada perdida: " + number);
    }
}
