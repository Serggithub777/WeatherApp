package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ScreenMainActivity extends AppCompatActivity {

    private static final String MY_LOG = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Log.d(MY_LOG, "ScreenMainActivity onCreate()");

    }
}
