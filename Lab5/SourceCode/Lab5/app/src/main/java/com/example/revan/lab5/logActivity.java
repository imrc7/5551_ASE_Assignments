package com.example.revan.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class logActivity extends AppCompatActivity {

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

                    Intent redirect = new Intent(logActivity.this, GoogleActivity.class);
                    startActivity(redirect);
                }




            }});}

    public void regPage(View v) {
        Intent redirect = new Intent(logActivity.this, RegActivity.class);
        startActivity(redirect);
    }

}

