package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by admin on 5/6/2015.
 */
public class RadioGroupActivity extends Activity {
    DatabaseHelper Rdb;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiogroup);
        Rdb = new DatabaseHelper(this);
        final EditText customer= (EditText) findViewById(R.id.rEdt);
        final EditText country= (EditText) findViewById(R.id.cntryEdt);

        Button upload= (Button) findViewById(R.id.upload);
        Button fetchR= (Button) findViewById(R.id.fetchradio);



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 RadioGroup rg= (RadioGroup) findViewById(R.id.rgDb);
               String type=null;
                switch (rg.getCheckedRadioButtonId())

                {
                    case R.id.radioButton:
                        type="vegetarian";
                        break;
                    case R.id.radioButton2:
                        type="non vegetarian";
                        break;

                }




              boolean isSel= Rdb.insertRadio(customer.getText().toString(),type.toString(),country.getText().toString());
                if(isSel)
                {
                    Toast.makeText(RadioGroupActivity.this,"inserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(RadioGroupActivity.this,"not inserted",Toast.LENGTH_LONG).show();
                }
                customer.getText().clear();
                country.getText().clear();
            }
        });
        fetchR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String store=Rdb.getRadio();
                Toast.makeText(RadioGroupActivity.this,"stored items are: "+store,Toast.LENGTH_LONG).show();
            }
        });
    }
}
