package com.debud.admin.spinnerdatabase;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/19/2015.
 */
public class GridViewAdapter extends ArrayAdapter {
    ArrayList<Items> itemsData=new ArrayList<>();
    Context context;
    int resourceId;
    public GridViewAdapter(Context context, int resource, ArrayList<Items> data) {
     super(context, resource, data);
     this.context=context;
        this.resourceId=resource;
        this.itemsData=data;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Items item=itemsData.get(position);
        ViewHolder viewHolder;

        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.grid_row,null);
            viewHolder.titleTxt= (TextView) convertView.findViewById(R.id.gridText);
            viewHolder.image= (ImageView) convertView.findViewById(R.id.gridImage);
            convertView.setTag(viewHolder);
        }
        else
        {
        viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTxt.setText(item.getTitle());

        viewHolder.image.setImageBitmap(item.getImages());
        return convertView;
    }
    private static class ViewHolder
    {
        TextView titleTxt;
        ImageView image;
    }
}
