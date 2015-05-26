package com.debud.admin.spinnerdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;

/**
 * Created by admin on 5/5/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="spinner.db";
    public static final String TABLE_NAME="spin";
    public static final String TABLE_RADIO="radio";
    public static final String TABLE_LOCATION="location";
    public static final String TABLE_IMAGE="imagetble";
    public static final String COL_1="_id";
    public static final String COL_2="name";
    public static final String COL_3="bookselected";
    public static final String COL_4="cststatus";
    public static final String COL_5="customer";
    public static final String COL_6="contry";
    public static final String Col_IMGID="_id";
    public static final String COL_IMG="image";
    public static final String Col_locationid="_id";
    public static final String Col_locationname="name";
    public static final String Col_latitude="latitude";
    public static final String Col_longitude="longitude";

    Context context;
    public static final String CREATE_TABLE_RADIO = " CREATE TABLE " + TABLE_RADIO + "("
            + COL_1 + " INTEGER PRIMARY KEY, " + COL_5 + " TEXT, " + COL_4 + " TEXT," + COL_6 + " TEXT " +")";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,4);
        this.context = context;
        Log.d("DatabaseHelper","database created");
        Log.d("DatabaseHelper","location table created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + "("
                + COL_1 + " INTEGER PRIMARY KEY, " + COL_2 + " TEXT, "
                + COL_3 + " TEXT" +")";

        String IMG_TABLE= " CREATE TABLE " + TABLE_IMAGE + "( "
                + Col_IMGID + " INTEGER PRIMARY KEY, " +COL_IMG+ " BLOB" +")";

        String CREATE_LOCATION_TABLE=" CREATE TABLE " + TABLE_LOCATION + "(" + Col_locationid + " INTEGER PRIMARY KEY,"
                + Col_locationname + " TEXT, " + Col_latitude + " INTEGER," + Col_longitude + " INTEGER" +")";
        db.execSQL(CREATE_TABLE);

        db.execSQL(CREATE_TABLE_RADIO);
        db.execSQL(IMG_TABLE);
        db.execSQL(CREATE_LOCATION_TABLE);

        Log.d("DatabaseHelper","table radio created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_RADIO );
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_IMAGE);
        db.execSQL(" DROP TABLE IF EXISTS " +TABLE_LOCATION);
        onCreate(db);
    }
    public boolean insert(String name,String book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,book);
        long res= db.insert(TABLE_NAME,null,contentValues);
        if (res==-1)

        {
            return  false;

        }
        else
            return true;
    }
    public Cursor getLocation()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(" SELECT * FROM " +TABLE_LOCATION,null);
        return  cursor;

    }
    public boolean insertLocation(String name,double latitutde, double longitude)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col_locationname,name);
        cv.put(Col_latitude,latitutde);
        cv.put(Col_longitude,longitude);
        long loc=db.insert(TABLE_LOCATION,null,cv);
        if(loc==-1){
            return  false;
        }
        return  true;
    }
    public void insertImage(byte[] img)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        //cv.put(Col_IMGID,"id");
        cv.put(COL_IMG,img);
        db.insert(TABLE_IMAGE, null, cv);
    }
    public void insertArrayOfImages(byte[][] imagearray)
    {
        {
            for(int i = 0 ; i < imagearray.length ; i++)
                insertImage(imagearray[i]);
        }
    }
    public Bitmap getImage()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor imgcursor=db.rawQuery(" SELECT * FROM " +TABLE_IMAGE, null);
        Bitmap b=null;
        while (imgcursor.moveToNext())
        {    imgcursor.getString(0);
            byte[] image=imgcursor.getBlob(1);
            b=BitmapFactory.decodeByteArray(image,0,image.length);

        }
        return b;
    }

    public Cursor getcursorimage()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c1=db.rawQuery(" SELECT * FROM " +TABLE_IMAGE,null);
        while(c1.moveToNext())
        {
           c1.getString(0);

           c1.getBlob(c1.getColumnIndex(COL_IMG));

            //Bitmap bitmap=BitmapFactory.decodeByteArray(img,0,img.length);
        }
        return c1;
    }
    public boolean insertRadio(String name,String status,String country)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_5,name);
        cv.put(COL_4,status);
        cv.put(COL_6,country);
        long result= db.insert(TABLE_RADIO,null,cv);
        if (result==-1)
        {
            return  false;

        }
        else
            return true;
    }
    public String getRadio()
    {StringBuffer bffer=new StringBuffer();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM " +TABLE_RADIO,null );
        while (c.moveToNext())
        {
            bffer.append("id: "+c.getString(0)+ "\n");
            bffer.append("name: "+c.getString(1)+ "\n");
            bffer.append("status: "+c.getString(2)+ "\n");
            bffer.append("country: "+c.getString(3)+ "\n");
        }
        c.close();
        return bffer.toString();
    }
    public ArrayList getArrayData()
    {
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor alldata=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while(alldata.moveToNext())
        {
            arrayList.add(alldata.getString(alldata.getColumnIndex(COL_1)));
            arrayList.add(alldata.getString(alldata.getColumnIndex(COL_2)));
            arrayList.add(alldata.getString(alldata.getColumnIndex(COL_3)));
        }
        alldata.close();
        return arrayList;

    }
    public ArrayList<Book> getAllData() {
        ArrayList<Book> arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor alldata = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        while (alldata.moveToNext()) {
            Book book = new Book(
                    alldata.getString(alldata.getColumnIndex(COL_1)),
                    alldata.getString(alldata.getColumnIndex(COL_2)),
                    alldata.getString(alldata.getColumnIndex(COL_3)));
            arrayList.add(book);
        }
        alldata.close();
        return arrayList;

    }
    public ArrayList<Image> getArrayImage()
    {
        ArrayList<Image> imageArrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor imgcursor=db.rawQuery(" SELECT * FROM " +TABLE_IMAGE,null);
        while (imgcursor.moveToNext())

        {   Image image=new Image(
            imgcursor.getString(imgcursor.getColumnIndex(Col_IMGID)),
            imgcursor.getBlob(imgcursor.getColumnIndex(COL_IMG)));

            byte[] bytearray=imgcursor.getBlob(imgcursor.getColumnIndex(COL_IMG));
            Bitmap bitmap=BitmapFactory.decodeByteArray(bytearray,0,bytearray.length);

            imageArrayList.add(image);
        }
        imgcursor.close();
        return imageArrayList;
    }
    public Cursor getAll()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM " +TABLE_NAME,null);
        //cursor.close();
        return cursor;



    }
    public void close(SQLiteDatabase db)
    {
        db.close();
    }
}

