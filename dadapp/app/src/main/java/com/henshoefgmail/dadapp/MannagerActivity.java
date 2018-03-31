package com.henshoefgmail.dadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MannagerActivity extends AppCompatActivity {
private String username;
private String pass;
private EditText userText;
private EditText passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mannager);
        userText=(EditText)findViewById(R.id.username);
        passText=(EditText)findViewById(R.id.pass);

    }
    public void loginClick (View v){
        username=userText.getText().toString();
        pass=passText.getText().toString();
        Intent i = new Intent(this,SelfSettingsActivity.class);
        if(username.equals("Arikshoef")&&pass.equals("14453")){
            startActivity(i);
        }else {
            Toast toast=Toast.makeText(this,getResources().getString(R.string.details),Toast.LENGTH_LONG);
            toast.show();
        }

    }
    public void cancelClick (View v){
        finish();
    }
}
