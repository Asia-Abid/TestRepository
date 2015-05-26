package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by admin on 5/15/2015.
 */
public class ImageMainActivity extends Activity {
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagelistview);
        mydb=new DatabaseHelper(this);
        ListView listView= (ListView) findViewById(R.id.imageListView);
        ArrayList<Image> arrayList=mydb.getArrayData();
        ImageAdapter imageAdapter=new ImageAdapter(ImageMainActivity.this,R.layout.image_row_layout,arrayList);
        listView.setAdapter(imageAdapter);

    }
}
