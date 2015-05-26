package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

/**
 * Created by admin on 5/19/2015.
 */
public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        TextView txt= (TextView) findViewById(R.id.textViewwelcme);
        Date dt=new Date();
        int hour=dt.getHours();
        int minute=dt.getMinutes();
        txt.setText(hour+ " : "+minute);


    }

}
