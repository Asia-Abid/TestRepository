package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by admin on 5/11/2015.
 */
public class ListViewArray extends Activity {
    DatabaseHelper mydb;
    int[] columnIds = new int[] {R.id.textviewkey, R.id.textviewvalue, R.id.textView};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listarray);
        mydb=new DatabaseHelper(this);
        ListView listarray= (ListView) findViewById(R.id.listViewArray);
        ArrayList myarraylist=mydb.getArrayData();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(ListViewArray.this,R.layout.rowarray,R.id.textarray,myarraylist);
        listarray.setAdapter(arrayAdapter);
    }
}
