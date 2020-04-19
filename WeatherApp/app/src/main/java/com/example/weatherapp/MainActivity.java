package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String MY_LOG = "MyLog";
    private static final String KEY_CITY_NAME = "CITY_NAME";
    private Button settings;
    private Button showWeather;
    private View.OnClickListener listenerClickShowWeather;
    private View.OnClickListener listenerClickSettings;
    private EditText editTextEnterCity;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Toast.makeText(getApplicationContext(), R.string.startToast, Toast.LENGTH_SHORT).show();
        }
        editTextEnterCity = findViewById(R.id.editTextEnterCity);
        settings = findViewById(R.id.buttonSettings);
        showWeather = findViewById(R.id.buttonShowWeather);

        listenerClickShowWeather = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityName = editTextEnterCity.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, ScreenMainActivity.class);
                if (cityName.isEmpty()) {
                   makeToast("Enter city!");
                } else {
                    intent.putExtra(KEY_CITY_NAME, cityName);
                    startActivity(intent);
                    Log.d(MY_LOG, "MainActivity onClick() Show Weather");
                }
            }
        };

        listenerClickSettings = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingsScreenActivity.class);
                startActivity(intent);

            }
        };

        showWeather.setOnClickListener(listenerClickShowWeather);
        settings.setOnClickListener(listenerClickSettings);

    }

    private void makeToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d(MY_LOG, msg);
    }
}

