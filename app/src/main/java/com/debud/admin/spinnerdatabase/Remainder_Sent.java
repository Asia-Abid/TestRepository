package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by admin on 5/21/2015.
 */
public class Remainder_Sent extends Activity {
    EditText remainder,timeEdtTxt;
    Button setRemainderBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remaindersent);
        //remainder= (EditText) findViewById(R.id.remainderEdtTxt);
        timeEdtTxt= (EditText) findViewById(R.id.timeEdtTxt);
        setRemainderBtn= (Button) findViewById(R.id.remainderBtn);


    }
    public void scheduleAlarm(View v)
    {
        Long time= Long.valueOf(timeEdtTxt.getText().toString());
        Intent intent=new Intent(Remainder_Sent.this,ReceieveRemain.class);
        AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,time,PendingIntent.getBroadcast(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(Remainder_Sent.this,"alarm schedule at "+time,Toast.LENGTH_LONG).show();

    }
}
