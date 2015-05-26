package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by admin on 5/18/2015.
 */
public class InternalImageActivity extends Activity {
    Bitmap image;
    //private static final String FILE_NAME="myInternalFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internalimagestorage);
        Button internalSave= (Button) findViewById(R.id.internalSave);
        Button internalFetch= (Button) findViewById(R.id.internaFetch);


        internalSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextWrapper cw=new ContextWrapper(getApplicationContext());
                File directory=cw.getDir("mydirectory",MODE_PRIVATE);
                File path=new File(directory,"myInternalFile.png");
                try{
                    FileOutputStream fos=new FileOutputStream(path);
                    image.compress(Bitmap.CompressFormat.PNG,100,fos);
                    Toast.makeText(InternalImageActivity.this," insert success",Toast.LENGTH_LONG).show();
                    fos.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        internalFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File filepath=new File("path");
                    if(filepath.exists())
                    {
                        Bitmap bitmap= BitmapFactory.decodeFile(filepath.getAbsolutePath());
                        ImageView img= (ImageView) findViewById(R.id.internalImageView);
                        img.setImageBitmap(bitmap);
                        Toast.makeText(InternalImageActivity.this,"fetch success",Toast.LENGTH_LONG).show();

                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }


            }
        });

    }
}
