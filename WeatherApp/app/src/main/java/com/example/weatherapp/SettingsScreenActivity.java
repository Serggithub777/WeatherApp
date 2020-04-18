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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_settings);
        Log.d(MY_LOG, "SettingsScreenActivity onCreate()");

        checkBoxShowWind = findViewById(R.id.checkBoxShowWind);
        checkBoxShowPressure = findViewById(R.id.checkBoxShowPressure);
        checkBoxShowRainProbably = findViewById(R.id.checkBoxShowRainProbably);

        saveChanges = findViewById(R.id.buttonSaveChanges);
        listenerSaveChanges = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsScreenActivity.this, ScreenMainActivity.class);
                startActivity(intent);
                Log.d(MY_LOG, "SettingsScreenActivity onClick() SaveChanges");
            }
        };
        saveChanges.setOnClickListener(listenerSaveChanges);
    }


    public void checkBoxShowWindClicked(View view) {
        if (checkBoxShowWind.isChecked()) {
            checkBoxShowWindEnabled = ENABLED;
            makeToast("CheckBox Wind Speed enabled");
        }else{
            checkBoxShowWindEnabled = DISABLED;
            makeToast("CheckBox Wind Speed disabled");
        }
    }
    public void checkBoxShowPressureClicked(View view) {
        if (checkBoxShowPressure.isChecked()) {
            checkBoxShowPressureEnabled = ENABLED;
            makeToast("CheckBox Air Pressure enabled");
        }else{
            checkBoxShowPressureEnabled = DISABLED;
            makeToast("CheckBox Air Pressure disabled");
        }
    }

    public void checkBoxShowRainProbablyClicked(View view) {
        if (checkBoxShowRainProbably.isChecked()) {
            checkBoxShowRainProbablyEnabled = ENABLED;
            makeToast("CheckBox Rain Possibility enabled");
        }else{
            checkBoxShowRainProbablyEnabled = DISABLED;
            makeToast("CheckBox Rain Possibility disabled");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("wind",checkBoxShowWindEnabled);
        outState.putString("pressure",checkBoxShowPressureEnabled);
        outState.putString("probably", checkBoxShowRainProbablyEnabled);
        makeToast("Сохранение данных CheckBox");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        checkBoxShowWindEnabled = savedInstanceState.getString("wind");
        checkBoxShowPressureEnabled = savedInstanceState.getString("pressure");
        checkBoxShowRainProbablyEnabled = savedInstanceState.getString("probably");
        makeToast("Восстановление данных CheckBox");
    }

    private void makeToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d(MY_LOG, msg);
    }



}
