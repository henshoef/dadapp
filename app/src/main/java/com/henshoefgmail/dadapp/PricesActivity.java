package com.henshoefgmail.dadapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class PricesActivity extends AppCompatActivity {
    DataBase db;
    List<Tire> names;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices);
        db=new DataBase(this);
    }
    public void loadTires(){
        names =db.getAllTiresList();//get list of movies from the data base
        int i =0;
        if (names.size() == i) {

        } else {
            while(i<names.size()) {
                String n = names.get(i).getName();
                String s = names.get(i).getSize();
                int id =names.get(i).getId();
                i++;
            }
        }
    }
}
