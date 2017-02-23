package com.example.revan.lab5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.*;

import static com.example.revan.lab5.R.id.email;
import static com.example.revan.lab5.R.id.password;

public class RegActivity extends AppCompatActivity {

    String userChoosenTask;
    int TAKE_PHOTO_CODE = 0;
    int SELECT_FILE =1;
    ImageView userImage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        userImage = (ImageView) findViewById(R.id.imageView);
        ImageButton capture = (ImageButton) findViewById(R.id.imageButton);
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final CharSequence[] items = { "Take Photo", "Choose from Gallery", "Cancel" };
                AlertDialog.Builder builder = new AlertDialog.Builder(RegActivity.this);
                builder.setTitle("Upload Photo!");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Take Photo")) {
                            userChoosenTask = "Take Photo";
                            //Invoke camera
                            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);

                        } else if (items[item].equals("Choose from Gallery")) {
                            userChoosenTask = "Choose from Gallery";
                            //Invoke Gallery of image only
                            Intent intent = new Intent();
                            intent.setType("image/*");
                            intent.setAction(Intent.ACTION_GET_CONTENT);//
                            startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
                        } else if (items[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                AlertDialog builder1 = builder.create();
                builder1.show();
            }
        });
    }



    Bitmap photo = null;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK && data != null) {
            photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
            Log.d("CameraDemo", "Pic saved");
        }else if(requestCode == SELECT_FILE && resultCode == RESULT_OK && data != null){
            try {
                photo = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                userImage.setImageBitmap(photo);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void redirectToHome(View v){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //Compressing Photo
        photo.compress(Bitmap.CompressFormat.PNG, 80, stream);
        byte[] bytes = stream.toByteArray();
        Intent redirect = new Intent(RegActivity.this, GoogleActivity.class);
        //Sending Photo bitmap
        redirect.putExtra("bmpimage",photo);
        startActivity(redirect);
    }


    name=(EditText)findViewById(R.id.name);
    email=(EditText)findViewById(email);
    phone=(EditText)findViewById(R.id.phone);
    password=(EditText)findViewById(password);
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






}