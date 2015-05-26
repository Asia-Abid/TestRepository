package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by admin on 5/13/2015.
 */
public class CustomDataBaseActivity extends Activity {

    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customlistview);
        mydb=new DatabaseHelper(this);
        ArrayList<Book> data=mydb.getAllData();

        ListView listView= (ListView) findViewById(R.id.customlistView);
        BooksAdapter booksAdapter =new BooksAdapter(CustomDataBaseActivity.this,R.layout.row_custom,data);
        Log.d("CustomDataBaseActivity","data is"+data);
        listView.setAdapter(booksAdapter);
    }
}
