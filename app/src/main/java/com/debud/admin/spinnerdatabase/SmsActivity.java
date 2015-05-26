package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by admin on 5/21/2015.
 */
public class SmsActivity extends Activity {
    EditText phone,msg;
    Button sendsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_layout);
        phone= (EditText) findViewById(R.id.phnEdtTxt);
        msg= (EditText) findViewById(R.id.msgEdtTxt);
        sendsms= (Button) findViewById(R.id.sendMsgBtn);
        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(phone.getText().toString(),null,msg.getText().toString(),null,null);
                Toast.makeText(SmsActivity.this,"sms send",Toast.LENGTH_LONG).show();
            }
        });

 }
}
