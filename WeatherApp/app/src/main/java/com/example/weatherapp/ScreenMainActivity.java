package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScreenMainActivity extends AppCompatActivity {
    private static final String KEY_CITY_NAME = "CITY_NAME";
    private static final String MY_LOG = "MyLog";
    private TextView textViewCityName;
    private TextView textViewTempMesur;
    private SaveParametrs instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        textViewCityName = findViewById(R.id.textViewCityName);
        textViewTempMesur = findViewById(R.id.textViewTempMesur);
        instance = SaveParametrs.getInstance();

        Bundle args = getIntent().getExtras();
        setCityName(args);
        setTemperatureMesur();
    }

    private void setCityName(Bundle args) {
        String cityName = args.getString(KEY_CITY_NAME);
        textViewCityName.setText(cityName);
    }

    private void setTemperatureMesur() {
        String set = instance.getTemperatureMesur();
        if (set.equals("c")) {
            textViewTempMesur.setText("C");
        }if(set.equals("f"))
            textViewTempMesur.setText("F");

    }
    private void makeToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d(MY_LOG, msg);
    }
}
