package com.debud.admin.spinnerdatabase;

/**
 * Created by admin on 5/12/2015.
 */
public class Book {
    public  String id="id";
    public  String name="name";
    public  String bookRef ="bookRef";

public Book(String id, String name, String bookRef){
    this.id=id;
   this.name=name;
    this.bookRef = bookRef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookRef() {
        return bookRef;
    }

    public void setBookRef(String bookRef) {
        this.bookRef = bookRef;
    }
}
