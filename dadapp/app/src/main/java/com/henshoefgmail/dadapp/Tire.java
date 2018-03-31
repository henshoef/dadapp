package com.henshoefgmail.dadapp;

/**
 * Created by hensh on 31/03/2018.
 */

public class Tire {
    private int id;
    private String name;
    private String size;

    public Tire(int id, String name, String size) {
        this.id = id;
        this.name = name;
        this.size = size;

    }
public Tire(){

}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
