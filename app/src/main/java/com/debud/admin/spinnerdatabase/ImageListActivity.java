package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.ByteArrayOutputStream;

/**
 * Created by admin on 5/15/2015.
 */
public class ImageListActivity extends Activity {
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagelistview);

        mydb=new DatabaseHelper(this);
        ListView listViewimage= (ListView) findViewById(R.id.imageListView);

        Cursor imagelist=mydb.getcursorimage();
        String[] from={DatabaseHelper.Col_IMGID,DatabaseHelper.COL_IMG};
        int[] to={R.id.textView2,R.id.imageView2};
        SimpleCursorAdapter cursorAdapter=new SimpleCursorAdapter(ImageListActivity.this,R.layout.image_row_layout,imagelist,from,to,0);
        listViewimage.setAdapter(cursorAdapter);

    }
}
