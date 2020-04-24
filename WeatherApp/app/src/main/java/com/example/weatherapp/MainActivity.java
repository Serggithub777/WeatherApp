package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
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
        if (savedInstanceState == null) {
            FragmentManager fm =  getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction().replace(R.id.fragment_container, new ActivityMainFragment());
            ft.commit();
        }
    }
}
