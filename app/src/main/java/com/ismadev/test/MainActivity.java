package com.ismadev.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ismadev.magicsnackbar.MagicSnackBar;


public class MainActivity extends AppCompatActivity {
    MagicSnackBar magicSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        magicSnackBar = new MagicSnackBar(this);
        magicSnackBar.snackBar("Hello world");
        magicSnackBar.snackBarError("Error");
        magicSnackBar.setDuration(2233);
    }


}