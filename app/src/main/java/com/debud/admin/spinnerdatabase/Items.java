package com.debud.admin.spinnerdatabase;

import android.graphics.Bitmap;

/**
 * Created by admin on 5/19/2015.
 */
public class Items {
    String title;
    Bitmap images;

    public Bitmap getImages() {
        return images;
    }

    public void setImages(Bitmap images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Items(String title,Bitmap images)
    {
        this.title=title;
        this.images=images;
    }

}
