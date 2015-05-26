package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 5/25/2015.
 */
public class PractiseActivity extends Activity {
TextView dateTxt;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practiselayout);
       Date date=new Date();
        dateTxt= (TextView) findViewById(R.id.textView7);
        //date.getHours();
        dateTxt.setText("" + date.getHours()+":"+date.getMinutes());
        b1= (Button) findViewById(R.id.exBtn);
        b2= (Button) findViewById(R.id.exBtn1);
        b2.setVisibility(View.INVISIBLE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setVisibility(View.VISIBLE);
            }
        });

    }
}