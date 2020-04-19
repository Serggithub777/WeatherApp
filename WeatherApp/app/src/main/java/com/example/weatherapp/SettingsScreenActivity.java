package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SettingsScreenActivity extends AppCompatActivity {
    public static final String MY_LOG = "MyLog";
    public static final String ENABLED = "Enabled";
    public static final String DISABLED = "Disabled";
    private Button saveChanges;
    private View.OnClickListener listenerSaveChanges;
    private CheckBox checkBoxShowWind;
    private CheckBox checkBoxShowPressure;
    private CheckBox checkBoxShowRainProbably;
    private String checkBoxShowWindEnabled;
    private String checkBoxShowPressureEnabled;
    private String checkBoxShowRainProbablyEnabled;
    private String temperatureMesuriment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_settings);
        Log.d(MY_LOG, "SettingsScreenActivity onCreate()");

        final SaveParametrs instance = SaveParametrs.getInstance();

        checkBoxShowWind = findViewById(R.id.checkBoxShowWind);
        checkBoxShowPressure = findViewById(R.id.checkBoxShowPressure);
        checkBoxShowRainProbably = findViewById(R.id.checkBoxShowRainProbably);

        saveChanges = findViewById(R.id.buttonSaveChanges);
        listenerSaveChanges = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsScreenActivity.this, MainActivity.class);
                startActivity(intent);
                Log.d(MY_LOG, "SettingsScreenActivity onClick() SaveChanges");
            }
        };
        saveChanges.setOnClickListener(listenerSaveChanges);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        makeToast("Сохранение данных CheckBox");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        makeToast("Восстановление данных CheckBox");
    }

    private void makeToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d(MY_LOG, msg);
    }
}
