package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 5/19/2015.
 */
public class GridViewMain extends Activity {

    ArrayList<Items> itemarray=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewlayout);
        final GridView gridView= (GridView) findViewById(R.id.gridView);
        Bitmap iclauncher= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
        Bitmap media=BitmapFactory.decodeResource(getResources(),R.drawable.media);
        itemarray.add(new Items("item1",iclauncher));
        itemarray.add(new Items("item2",media));
        itemarray.add(new Items("item3",iclauncher));
        itemarray.add(new Items("item4",media));
        itemarray.add(new Items("item5",iclauncher));
        itemarray.add(new Items("item6",media));
        GridViewAdapter adapter=new GridViewAdapter(GridViewMain.this,R.layout.image_row_layout,itemarray);
        gridView.setAdapter(adapter);

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    Intent i1=new Intent(GridViewMain.this,WelcomeActivity.class);
                    startActivity(i1);
                    break;
                case 1:
                    Toast.makeText(GridViewMain.this,"media clicked at" +(position+1),Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(GridViewMain.this,"media clicked at" +(position+1),Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    Toast.makeText(GridViewMain.this,"media clicked at" +(position+1),Toast.LENGTH_LONG).show();
                    break;
                case 4:
                    Toast.makeText(GridViewMain.this,"media clicked at" +(position+1),Toast.LENGTH_LONG).show();
                    break;
                case 5:
                    Toast.makeText(GridViewMain.this,"media clicked at" +(position+1),Toast.LENGTH_LONG).show();
                    break;
            }
        }
    });
    }
}
