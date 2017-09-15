package com.example.alireza.marathon.Activiity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alireza.marathon.R;

/**
 * Created by alireza on 9/14/2017.
 */

public class LoginActivity extends Activity {
    EditText inputEmail ;
    EditText inputPassword;
    Button btnLogin;
    TextView txtSignup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Typeface font = Typeface.createFromAsset(getAssets(),"Shabnam.ttf");
       // callLoginDialog();
        inputEmail = findViewById(R.id.input_email);
        inputEmail.setTypeface(font);
        inputPassword = findViewById(R.id.input_password);
        inputPassword.setTypeface(font);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setTypeface(font);
        txtSignup = findViewById(R.id.link_signup);
        txtSignup.setTypeface(font);

        TextView txtForgottenPass = findViewById(R.id.txt_forgotenPass);
        txtForgottenPass.setTypeface(font);
        TextView txtWelcom = findViewById(R.id.txt_welcome);
        txtWelcom.setTypeface(font);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a  = new Intent(LoginActivity.this , SignupActiviy.class);
                startActivity(a);
            }
        });


    }




    public void login() {


        if (!validate()) {
            onLoginFailed();
            return;
        }
        btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.Theme_AppCompat_Light_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("در حال اعتبار سنجی ...");
        progressDialog.show();


        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        onLoginSuccess();

                    }
                }, 3000);

    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "ورود ناموفق", Toast.LENGTH_LONG).show();

        btnLogin.setEnabled(true);
    }


    public void onLoginSuccess() {
        btnLogin.setEnabled(true);
        Intent a = new Intent(LoginActivity.this , HomeActivity.class);
        startActivity(a);
        finish();
    }

    public boolean validate() {
        boolean valid = true;

        if (inputEmail.getText().toString().equals("") ||
                !android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText().toString()).matches()) {
            inputEmail.setError("آدرس ایمیل معتبر نیست");
            valid = false;
        } else {
            inputEmail.setError(null);
        }

        if (inputPassword.getText().toString().equals("") || inputPassword.getText().toString().length() < 4) {
            inputPassword.setError("شامل حداقل 4 کاراکتر حرفی و عددی  ");
            valid = false;
        } else {
            inputPassword.setError(null);
        }

        return valid;
    }
}
