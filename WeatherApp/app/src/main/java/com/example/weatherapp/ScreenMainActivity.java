package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScreenMainActivity extends AppCompatActivity {
    private static final String KEY_CITY_NAME = "CITY_NAME";
    private static final String MY_LOG = "MyLog";
    private TextView textViewCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        textViewCityName = findViewById(R.id.textViewCityName);

        Bundle args = getIntent().getExtras();
        setCityName(args);
    }

    private void setCityName(Bundle args) {
        String cityName = args.getString(KEY_CITY_NAME);
        textViewCityName.setText(cityName);
    }
}
