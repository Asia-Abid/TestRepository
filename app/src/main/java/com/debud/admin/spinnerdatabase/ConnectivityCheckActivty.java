package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 5/22/2015.
 */
public class ConnectivityCheckActivty extends Activity {
    Button connect;
    WebView webView;
    public static final String Tag="ConnectivityCheckActivty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connectivity_checking);
        connect= (Button) findViewById(R.id.connectBtn);
        webView= (WebView) findViewById(R.id.connectWebView);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                boolean isMobileNetwork=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
                boolean isWifi=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
                if(isMobileNetwork)
                {
                    Toast.makeText(ConnectivityCheckActivty.this,"Its Mobile Data Turn On WIFI",Toast.LENGTH_LONG).show();
                }
                else if(isWifi) {
                    Toast.makeText(ConnectivityCheckActivty.this,"connected loading....",Toast.LENGTH_LONG).show();
                    System.out.print("loading url");
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl("http://google.com/");
                }
                else
                {
                    Toast.makeText(ConnectivityCheckActivty.this,"no connection",Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
