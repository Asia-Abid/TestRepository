package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by admin on 5/22/2015.
 */
public class ConnectionTestActivity extends Activity {
    Button go;
    WebView webView;
    EditText urlEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewexample);
        urlEdt= (EditText) findViewById(R.id.enterUrlTxt);
        go= (Button) findViewById(R.id.goBtn);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                boolean isConnectedToWifi=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
                if(isConnectedToWifi)
                {
                    Toast.makeText(ConnectionTestActivity.this,"loading...",Toast.LENGTH_LONG).show();
                    webView= (WebView) findViewById(R.id.testWebView);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(urlEdt.getText().toString());

                }
                else
                {
                    Toast.makeText(ConnectionTestActivity.this,"no connection",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
