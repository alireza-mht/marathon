package com.example.alireza.marathon.Activiity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.alireza.marathon.R;

/**
 * Created by alireza on 9/14/2017.
 */

public class SignupActiviy extends Activity {

    TextView txtLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtLogin = findViewById(R.id.link_login);




    }
}
