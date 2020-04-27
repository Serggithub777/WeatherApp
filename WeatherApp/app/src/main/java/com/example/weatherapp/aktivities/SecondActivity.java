package com.example.weatherapp.aktivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.weatherapp.R;
import com.example.weatherapp.fragments.ScreenMainFragment;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String cityName = getIntent().getStringExtra("CITY_NAME");
        FragmentManager fragmentManager = getSupportFragmentManager();
        ScreenMainFragment screenMainFragment = (ScreenMainFragment) fragmentManager.findFragmentById(R.id.screen_main_fragment);
        screenMainFragment.setTextViewCityName(cityName);
    }
}
