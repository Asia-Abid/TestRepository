package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by admin on 5/21/2015.
 */
public class Notification_Rev extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificationrev);
        TextView textView= (TextView) findViewById(R.id.notiTxt);
        textView.setText("hello world!!!");

    }
}
