package com.example.revan.lab4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText phone;
    EditText password;
    EditText confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phone);
        password=(EditText)findViewById(R.id.password);
        confirmpassword=(EditText)findViewById(R.id.confirmpassword);

        name.setError(null);

//        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {

        final Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        if(name.getText().toString().isEmpty() && email.getText().toString().isEmpty() && phone.getText().toString().isEmpty() && password.getText().length()<6 && confirmpassword.getText().toString().isEmpty() )
                {
                    name.setError("This field can not be empty");
                    email.setError("This field can not be empty");
                    phone.setError("This field can not be empty");
                    password.setError("Password should be minimum 6 characters");
                    confirmpassword.setError("This field can not be empty");
                }

        else if (name.getText().toString().isEmpty())
        {
            name.setError("This field can not be empty");
        }

                else if(email.getText().toString().isEmpty())

                {
                    email.setError("This field can not be empty");
                }

                else if (phone.getText().toString().isEmpty())
                {
                    phone.setError("This field can not be empty");
                }

        else if(password.getText().toString().isEmpty())
        {
            password.setError("This field can not be empty");
        }

                else if(password.getText().length()<6)
                {
                    password.setError("Password should be minimum 6 characters");
                }

                else if(confirmpassword.getText().toString().isEmpty())
                {
                    confirmpassword.setError("This field can not be empty");
                }




else {
            SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("email", email.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.commit();



            Intent redirect = new Intent(RegActivity.this, LogActivity.class);
            startActivity(redirect);

         dis();
        }


            }

        });

    }

    public void dis()
    {
        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show();
    }

    // save the users login info
//    public void logPag(View view)
//    {
//        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("email", email.getText().toString());
//        editor.putString("password",password.getText().toString());
//        editor.apply();
//    }



}
