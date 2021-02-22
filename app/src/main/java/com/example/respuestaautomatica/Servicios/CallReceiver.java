package com.example.respuestaautomatica.Servicios;

import android.content.Context;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.example.respuestaautomatica.MainActivity;

import java.util.Date;

public class CallReceiver extends PhoneCallReceiver {
    @Override
    protected void onIncomingCallReceived(Context ctx, String number, Date start) {
        Log.d("ICR", "Llamada recibida: " + number);
        if(number.equals(MainActivity.telefono)){
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(MainActivity.mensaje, null, MainActivity.mensaje, null, null);
            Toast.makeText(ctx, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
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

    }
}
