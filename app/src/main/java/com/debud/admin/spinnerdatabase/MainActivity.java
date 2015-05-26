package com.debud.admin.spinnerdatabase;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    String[] books={"bookRef 1","bookRef 2","bookRef 3","bookRef 4","bookRef 5"};
DatabaseHelper exdb;

    //public int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exdb = new DatabaseHelper(this);
        final EditText name = (EditText) findViewById(R.id.editText);
        final Spinner sp = (Spinner) findViewById(R.id.spinnerdb);
        Button save = (Button) findViewById(R.id.buttonsp);
        Button fetchArray = (Button) findViewById(R.id.buttonArray);
        Button fetchCustom = (Button) findViewById(R.id.simpleAbtn);
        Button fetch = (Button) findViewById(R.id.buttonft);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, books);
        sp.setAdapter(arrayAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "item selected " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


       // final String selname = name.getText().toString();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String select =sp.getSelectedItem().toString();
                boolean inserted = exdb.insert( name.getText().toString(), select);
                if (inserted) {
                    Toast.makeText(MainActivity.this,"name :" +name.getText().toString()+"and bookRef :" +select+ " is inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, " not inserted", Toast.LENGTH_LONG).show();
                }
                name.getText().clear();
            }
        });
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(MainActivity.this,ListDbActivity.class);
                startActivity(i);

            }
        });
        fetchArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,ListViewArray.class);
                startActivity(i2);
            }
        });
        fetchCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(MainActivity.this,CustomDataBaseActivity.class);
                startActivity(i3);
            }
        });
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }




        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
