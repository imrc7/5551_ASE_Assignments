package com.example.revan.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {

    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        final Button button1 = (Button) findViewById(R.id.login);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(email.getText().toString().isEmpty() &&  password.getText().toString().isEmpty() )
                {

                    email.setError("Email can not be empty");
                    password.setError("Password can not be empty");

                }

else{

                    Intent redirect = new Intent(LogActivity.this, MainActivity.class);
                    startActivity(redirect);
                }




        }});}}


//
//        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (email.getText().toString().isEmpty()) {
//                    email.setError("Email can not be empty");
//                }
//
//            }
//        });
//
//                password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//                    @Override
//                    public void onFocusChange(View v, boolean hasFocus) {
//                        if (password.getText().toString().isEmpty()) {
//                            password.setError("Password can not be empty");
//                        }
//                    }
//
//                });
//
//    }
//    public void mainPage(View v) {
//        EditText usernameCtrl = (EditText) findViewById(R.id.email);
//        EditText passwordCtrl = (EditText) findViewById(R.id.password);
//        TextView errorText = (TextView) findViewById(R.id.error);
//        String userName = usernameCtrl.getText().toString();
//        String password = passwordCtrl.getText().toString();
//
//        boolean validationFlag = false;
//        //Verify if the username and password are not empty.
//        if (!userName.isEmpty() && !password.isEmpty()) {
//            if (userName.equals("rcww4@mail.umkc.edu") && password.equals("1234")) {
//                validationFlag = true;
//
//            }
//        }
//        if (!validationFlag) {
//            errorText.setVisibility(View.VISIBLE);
//        } else {
//            //This code redirects the from login page to the home page.
//            Intent redirect = new Intent(LogActivity.this, MainActivity.class);
//            startActivity(redirect);
//        }
//
//    }
//    public void regPage(View v) {
//        Intent redirect = new Intent(LogActivity.this, RegActivity.class);
//        startActivity(redirect);
//    }
//
////    public void mainPage(View v) {
////        Intent redirect = new Intent(LogActivity.this, MainActivity.class);
////        startActivity(redirect);
////    }
//
//}
