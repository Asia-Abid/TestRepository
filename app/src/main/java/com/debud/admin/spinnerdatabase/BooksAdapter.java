package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by admin on 5/12/2015.
 */
public class BooksAdapter extends ArrayAdapter<Book> {


    private final Context context;
    ArrayList<Book> booksItems;


    public BooksAdapter(Context context, int resource, ArrayList<Book> dataarray) {
        super(context, resource, dataarray);
        this.context = context;
        this.booksItems =dataarray;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Book book = booksItems.get(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutResourceId  = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutResourceId.inflate(R.layout.row_custom, null);

            viewHolder.keyTV = (TextView) convertView.findViewById(R.id.keyid);
            viewHolder.nameTV= (TextView) convertView.findViewById(R.id.nameTxt);
            viewHolder.bookTV = (TextView) convertView.findViewById(R.id.bookTxt);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.keyTV.setText(book.getId());
        viewHolder.nameTV.setText(book.getName());
        viewHolder.bookTV.setText(book.getBookRef());
        return convertView;
    }
    private static class ViewHolder
    {
        TextView keyTV;
        TextView nameTV;
        TextView bookTV;
    }

}
