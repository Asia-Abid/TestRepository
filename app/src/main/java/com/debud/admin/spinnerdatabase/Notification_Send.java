package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin on 5/21/2015.
 */
public class Notification_Send extends Activity {
    int notificationId=01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificationsend);
        Button send= (Button) findViewById(R.id.sendNotiBtn);

    }
    public  void createNotification(View view)
    {
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder notification=new NotificationCompat.Builder(Notification_Send.this);
        notification.setSmallIcon(R.drawable.media);
        notification.setContentText("SUBJECT");
        notification.setContentTitle("NEW MAIL");


        Intent intent=new Intent(Notification_Send.this,Notification_Rev.class);
        PendingIntent pending=PendingIntent.getActivity(
                getApplicationContext(),0,intent,0);
        notification.setContentIntent(pending);
        notification.addAction(R.drawable.ic_launcher,"call",pending);
        notification.addAction(R.drawable.media,"message",pending);
        notificationManager.notify(notificationId,notification.build());
    }
}
