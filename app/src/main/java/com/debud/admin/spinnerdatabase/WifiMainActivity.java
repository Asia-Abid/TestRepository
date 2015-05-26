package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by admin on 5/20/2015.
 */
public class WifiMainActivity extends Activity {
    WifiManager wifiManager;
    WifiScanReceiver scanReceiver;
    String[] wifis;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifilayout);
        Button wifiEnable= (Button) findViewById(R.id.wifiEnbBtn);
        Button wifiScan= (Button) findViewById(R.id.wifiScanBtn);
        listView= (ListView) findViewById(R.id.wifiListView);
        wifiScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 wifiManager= (WifiManager) getSystemService(Context.WIFI_SERVICE);
                 scanReceiver=new WifiScanReceiver();
                wifiManager.startScan();
            }
        });
    }
    private class WifiScanReceiver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent) {
            List wifiscanlist=wifiManager.getScanResults();
            wifis=new String[wifiscanlist.size()];
            for(int i=0;i<wifiscanlist.size();i++)
            {
                wifis[i] =(wifiscanlist.get(i).toString());
            }
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter(WifiMainActivity.this,R.layout.support_simple_spinner_dropdown_item,wifis);
            listView.setAdapter(arrayAdapter);
        }
    }
}
