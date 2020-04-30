package com.example.weatherapp.aktivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.weatherapp.fragments.ActivityMainFragment;
import com.example.weatherapp.R;
import com.example.weatherapp.fragments.SettingsAddFragment;

public class MainActivity extends AppCompatActivity {
    private int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm =  getSupportFragmentManager();
        if (savedInstanceState == null) {
             FragmentTransaction ft = fm.beginTransaction().replace(R.id.main_activity_container, new ActivityMainFragment());
            ft.commit();
        } else{
            FragmentTransaction fragmentTransaction = fm.beginTransaction().replace(R.id.main_activity_container, new SettingsAddFragment());
        }
    }}


