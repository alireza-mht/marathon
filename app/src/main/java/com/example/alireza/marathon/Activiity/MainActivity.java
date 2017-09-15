package com.example.alireza.marathon.Activiity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.alireza.marathon.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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