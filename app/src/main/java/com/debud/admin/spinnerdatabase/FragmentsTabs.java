package com.debud.admin.spinnerdatabase;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TabHost;

/**
 * Created by admin on 5/25/2015.
 */
public class FragmentsTabs extends TabActivity {
  TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintablayout);
        tabHost= (TabHost) findViewById(android.R.id.tabhost);
        TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");
        tab1.setIndicator("tab1");
        tab1.setContent(new Intent(FragmentsTabs.this,WelcomeActivity.class));
        tab2.setIndicator("tab2");
        tab2.setContent(new Intent(FragmentsTabs.this,SmsActivity.class));
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
    }
}
