package com.example.revan.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
    }

    public void home(View v) {
        Intent redirect = new Intent(LogoutActivity.this, LogActivity.class);
        startActivity(redirect);

        Toast.makeText(this, "You are redirected back to login", Toast.LENGTH_LONG).show();
    }
}
