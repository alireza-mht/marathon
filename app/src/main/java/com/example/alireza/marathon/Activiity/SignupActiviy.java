package com.example.alireza.marathon.Activiity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class SignupActiviy extends Activity {

    TextView txtLogin;
    EditText InputName;
    EditText InputEmail;
    EditText InputPassword;
    Button btnSignup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtLogin = findViewById(R.id.link_login);
        InputName = findViewById(R.id.input_name);
        InputEmail = findViewById(R.id.input_email);
        InputPassword = findViewById(R.id.input_password);
        btnSignup = findViewById(R.id.btn_signup);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(SignupActiviy.this, LoginActivity.class);
                startActivity(a);
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });



    }


    public void signup(){
        if (!validate()) {
            onSignupFailed();
            return;
        }

        btnSignup.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActiviy.this , R.style.Theme_AppCompat_Light_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account ...");
        progressDialog.show();


        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        onSignupSuccess();
                        progressDialog.dismiss();
                    }
                },3000
        );
    }

    public void onSignupSuccess() {
        btnSignup.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        btnSignup.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        if (InputName.getText().toString().equals("") || InputName.getText().toString().length() < 3) {
            InputName.setError("at least 3 characters");
            valid = false;
        } else {
            InputName.setError(null);
        }

        if (InputEmail.getText().toString().equals("")
                || !android.util.Patterns.EMAIL_ADDRESS.matcher(InputEmail.getText().toString()).matches()) {
            InputEmail.setError("enter a valid email address");
            valid = false;
        } else {
            InputEmail.setError(null);
        }

        if (InputPassword.getText().toString().equals("") || InputPassword.getText().toString().length() < 4
                || InputPassword.getText().toString().length() > 10) {
            InputPassword.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            InputPassword.setError(null);
        }

        return valid;
    }
}
