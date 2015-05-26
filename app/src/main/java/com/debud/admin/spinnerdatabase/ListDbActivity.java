package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by admin on 5/11/2015.
 */
public class ListDbActivity extends Activity {

    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdb);
        mydb=new DatabaseHelper(this);
        Cursor cursor=mydb.getAll();
        String[] from=new String[]{DatabaseHelper.COL_1, DatabaseHelper.COL_2, DatabaseHelper.COL_3};
        int[] to=new int[]{R.id.textviewkey,R.id.textviewvalue,R.id.textView};

       SimpleCursorAdapter myadapter;
        myadapter=new SimpleCursorAdapter(getBaseContext(),R.layout.row_layout,cursor,from,to,0);
        ListView list= (ListView) findViewById(R.id.listDb);
        list.setAdapter(myadapter);
    }

}
