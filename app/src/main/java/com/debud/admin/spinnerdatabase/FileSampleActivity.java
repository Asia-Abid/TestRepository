package com.debud.admin.spinnerdatabase;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by admin on 5/22/2015.
 */
public class FileSampleActivity extends Activity {
    TextView readTxt;
    Button fetch,save;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filesample);
        readTxt= (TextView) findViewById(R.id.fileTxt);
        text= (EditText) findViewById(R.id.fileEdtTxt);
        fetch= (Button) findViewById(R.id.fileFetchBtn);
        save= (Button) findViewById(R.id.fileStoreBtn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Toast.makeText(FileSampleActivity.this,"inserted: "+text.getText().toString(),Toast.LENGTH_LONG).show();
                    FileOutputStream fileOutputStream=openFileOutput("myFile",MODE_APPEND);
                    OutputStreamWriter writer=new OutputStreamWriter(fileOutputStream);
                    writer.write(text.getText().toString()+"\t");
                    writer.close();
                    Log.d("FileSampleActivity",getFilesDir().getAbsolutePath());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis=openFileInput("myFile");
                    int c;
                    String temp="";
                    while( (c = fis.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    readTxt.setText(temp);
                    text.getText().clear();

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

    }


}
