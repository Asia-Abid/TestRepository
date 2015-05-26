package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/12/2015.
 */
public class CustomListActivity extends Activity {
    String[] id={"1","2","3","4"};
    String[] name={"Lea Wilson  ","River Parker","Emily parker","john parker "};
    String[] book={"bookRef 1","bookRef 2","bookRef 3","bookRef 4"};
    ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customlistview);
        books = new ArrayList<Book>();
        for (int i=0;i<4;i++) {
            Book item = new Book(id[i], name[i], book[i]);
            books.add(item);
        }
        ListView customlist= (ListView) findViewById(R.id.customlistView);
        BooksAdapter adapter=new BooksAdapter(CustomListActivity.this,R.layout.row_custom, books);
        customlist.setAdapter(adapter);

    }
}
