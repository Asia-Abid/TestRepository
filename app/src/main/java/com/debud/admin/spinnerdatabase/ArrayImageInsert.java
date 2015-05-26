package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

/**
 * Created by admin on 5/15/2015.
 */
public class ArrayImageInsert extends Activity {
    DatabaseHelper mydb;
    Bitmap[] images={BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher),BitmapFactory.decodeResource(getResources(),R.drawable.media)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_array_layout);
        mydb=new DatabaseHelper(this);
        Button arrayimage= (Button) findViewById(R.id.arrayimageBtn);
        arrayimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[][] img=new byte[images.length][];
                for (int j=0; j<images.length; j++) {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    images[j].compress(Bitmap.CompressFormat.PNG, 100, bos);
                    img[j] = bos.toByteArray();
                    mydb.insertArrayOfImages(img);
                    Toast.makeText(ArrayImageInsert.this,"inserted",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
