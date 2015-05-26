package com.debud.admin.spinnerdatabase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by admin on 5/21/2015.
 */
public class ReceieveRemain extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String phoneNumberReciver="8801661761";// phone number to which SMS to be send
        String message="you have a meeting after an hour";// message to send
        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumberReciver,null,message,null,null);
        // Show the toast  like in above screen shot
        Toast.makeText(context, "Alarm Triggered and SMS Sent", Toast.LENGTH_LONG).show();
    }
}
