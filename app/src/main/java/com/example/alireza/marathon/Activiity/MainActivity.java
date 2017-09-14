package com.example.alireza.marathon.Activiity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.alireza.marathon.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent a = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(a);
                finish();
            }
        } , 1000);
    }
}