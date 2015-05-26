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
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/15/2015.
 */
public class ImageAdapter extends ArrayAdapter<Image> {
    ArrayList<Image> imageitems;
    private final Context context;

    public ImageAdapter(Context context, int resource, ArrayList<Image> imageitems) {
        super(context, resource, imageitems);
        this.context=context;
        this.imageitems=imageitems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Image image=imageitems.get(position);

        ViewHolder viewHolder ;

        if (convertView==null)
        { viewHolder=new ViewHolder();
            LayoutInflater layoutResourceId  = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutResourceId.inflate(R.layout.image_row_layout, null);
            viewHolder.imageTxt=(TextView) convertView.findViewById(R.id.textView2);

            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.imageView2);
            convertView.setTag(viewHolder);
        }
else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        byte[] outimage=image.image;
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outimage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        viewHolder.imageView.setImageBitmap(theImage);


       viewHolder.imageTxt.setText(image.getImgidId());
       //viewHolder.imageView.setImageDrawable((android.graphics.drawable.Drawable) image.getImage());
       return  convertView;
    }
    private class ViewHolder
    {
        TextView imageTxt;
        ImageView imageView;
    }
}
