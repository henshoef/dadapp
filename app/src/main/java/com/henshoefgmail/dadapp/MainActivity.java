package com.henshoefgmail.dadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickPrices(View v){
Intent intent=new Intent(this, PricesActivity.class);
startActivity(intent);

    }
    public void onClickManage(View v){
        Intent intent=new Intent(this, MannagerActivity.class);
        startActivity(intent);

    }
}
