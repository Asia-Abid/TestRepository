package com.debud.admin.spinnerdatabase;

import java.sql.Blob;

/**
 * Created by admin on 5/15/2015.
 */
public class Image {
    String imgid;
    byte[] image;

    public String getImgidId() {
        return imgid;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setImgidId(String id) {
        this.imgid = imgid;
    }

    public Image(String id, byte[] image)
    {
        this.imgid=imgid;

    }
}
