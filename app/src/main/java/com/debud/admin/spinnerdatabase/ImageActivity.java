package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

/**
 * Created by admin on 5/14/2015.
 */
public class ImageActivity extends Activity {
    DatabaseHelper mydb;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagelayout);
        mydb=new DatabaseHelper(this);
        Button save= (Button) findViewById(R.id.imgsave);
        Button fetch= (Button) findViewById(R.id.imgfetch);
        Button fetchlist= (Button) findViewById(R.id.buttonFetchList);

        final ImageView imageView= (ImageView) findViewById(R.id.imageView);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap1= BitmapFactory.decodeResource(getResources(),R.drawable.media);

                ByteArrayOutputStream bos=new ByteArrayOutputStream();
                bitmap1.compress(Bitmap.CompressFormat.JPEG,90,bos);

                byte[] img=bos.toByteArray();
                mydb.insertImage(img);
                Toast.makeText(ImageActivity.this,"inserted",Toast.LENGTH_LONG).show();
            }
        });
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bit=mydb.getImage();
                imageView.setImageBitmap(bit);
                Toast.makeText(ImageActivity.this,"data fetched",Toast.LENGTH_LONG).show();
                Log.d("ImageActvity", "data fetched");
            }
        });
        fetchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imgintent=new Intent(ImageActivity.this,ImageMainActivity.class);
                startActivity(imgintent);
            }
        });
    }
}
