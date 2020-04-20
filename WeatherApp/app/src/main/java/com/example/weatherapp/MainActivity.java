package com.example.weatherapp;

import androidx.annotation.NonNull;
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
    private SaveParametrs instance = SaveParametrs.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEnterCity = findViewById(R.id.editTextEnterCity);
        settings = findViewById(R.id.buttonSettings);
        showWeather = findViewById(R.id.buttonShowWeather);

        listenerClickShowWeather();
        listenerClickSettings();

        showWeather.setOnClickListener(listenerClickShowWeather);
        settings.setOnClickListener(listenerClickSettings);

    }

    private void listenerClickSettings() {
        listenerClickSettings = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsScreenActivity.class);
                startActivity(intent);

            }
        };
    }

    private void listenerClickShowWeather() {
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
    }

    private void makeToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d(MY_LOG, msg);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CITY_NAME, cityName);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Bundle s = getIntent().getExtras();
        String cityName = s.toString();
        editTextEnterCity.setText(cityName);
    }
}
