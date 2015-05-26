package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin on 5/19/2015.
 */
public class CameraActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        Button camera= (Button) findViewById(R.id.cameraBtn);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cam=new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(cam);
            }
        });
    }
}
