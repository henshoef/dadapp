package com.henshoefgmail.dadapp;

/**
 * Created by hensh on 31/03/2018.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;


//this class handles the all database tasks and extends the SQLiteOpenHelper (a build class)
//in this class we must to implement the methods "onCreate" and "onUpgrade" from the SQLiteOpenHelper class
public class DataBase extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "tiresPrices";

    public static final String TABLE_TIRES = "Tires";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "tireName";
    public static final String KEY_SIZE= "tireSize";

    //We need to pass database information along to superclass because the super class doesn't have any default constructor

    public DataBase(Context contex) {
        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //in the first time that we run this app we want to create our table in order to store data
    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE " + TABLE_TIRES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_SIZE + " TEXT,"

               ;

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIRES);

        // Create tables again
        onCreate(db);
    }




    public void clear() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TIRES,null,null);
        db.execSQL("delete from "+ TABLE_TIRES);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_TIRES );

        onCreate(db);
    }


    public void addTire(Tire tire){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, tire.getName());
        values.put(KEY_SIZE, tire.getSize());



        db.insert(TABLE_TIRES, null, values);
        db.close();
    }


    public boolean deleteTire(int delID) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_TIRES, KEY_ID + "=" + delID, null) > 0;

    }


    public List<Tire> getAllTiresList() {

        List<Tire> tiresList = new ArrayList<Tire>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TIRES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Tire tire = new Tire();
                tire.setId(Integer.parseInt(cursor.getString(0)));
                tire.setName(cursor.getString(1));
                tire.setSize(cursor.getString(2));

                // Adding contact to list
                tiresList.add(tire);

            } while (cursor.moveToNext());
        }

        // return contact list
        return tiresList;
    }

}

