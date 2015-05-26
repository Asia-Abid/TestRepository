package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by admin on 5/20/2015.
 */
public class GpsMainActivity extends Activity {
   TextView lat,longt,latitude,longitude;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpslayout);
        mydb=new DatabaseHelper(this);

        latitude= (TextView) findViewById(R.id.getlatTxt);
        longitude= (TextView) findViewById(R.id.getlongTxt);
        LocationManager locationManager= (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener=new myLocationListener();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,500,10,locationListener);

 }

    private class myLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(final Location location) {
       latitude.setText(" " + location.getLatitude());
       longitude.setText(" "+location.getLongitude());
           
        final EditText name= (EditText) findViewById(R.id.gpsname);
        Button save= (Button) findViewById(R.id.gpssaveBtn);
        Button fetch= (Button) findViewById(R.id.gpsfetchBtn);
       save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       boolean inserted= mydb.insertLocation(name.getText().toString(),location.getLatitude(),location.getLongitude());
        if(inserted)
        {
            Toast.makeText(GpsMainActivity.this,"inserted",Toast.LENGTH_LONG).show();
            name.getText().clear();
        }
else
        {
            Toast.makeText(GpsMainActivity.this,"not inserted",Toast.LENGTH_LONG).show();
        }
    }
});
            fetch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListView list= (ListView) findViewById(R.id.gpslistView);
                    String[] from={DatabaseHelper.Col_locationid, DatabaseHelper.Col_locationname, DatabaseHelper.Col_latitude,
                    DatabaseHelper.Col_longitude};
                    int[] to={R.id.gpsidTxt,R.id.gpsnameTxt,R.id.gpslatTxt,R.id.gpslongTxt};
                    Cursor rescursor=mydb.getLocation();

                    SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(GpsMainActivity.this,R.layout.gps_row,rescursor,from,to,0);
                    list.setAdapter(simpleCursorAdapter);
                }
            });
 }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(GpsMainActivity.this,"gps is on" +provider,Toast.LENGTH_LONG).show();

        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(GpsMainActivity.this,"gps is off "+provider,Toast.LENGTH_LONG).show();

        }
    }
}
