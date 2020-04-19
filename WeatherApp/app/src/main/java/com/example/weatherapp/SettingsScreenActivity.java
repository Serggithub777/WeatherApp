package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
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
    private RadioButton radioButtonSetTempMesurCelcium;
    private RadioButton radioButtonSetTempMesurFahren;
    private String checkBoxShowWindEnabled;
    private String checkBoxShowPressureEnabled;
    private String checkBoxShowRainProbablyEnabled;
    final SaveParametrs instance = SaveParametrs.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_settings);
        if (savedInstanceState == null) {
            makeToast("SettingsScreenActivity omCreate() Первый запуск!");
        } else
            makeToast("SettingsScreenActivity omCreate() Повторный запуск!");

        radioButtonSetTempMesurCelcium = findViewById(R.id.radioButtonSetTempMesurCelcium);
        radioButtonSetTempMesurFahren = findViewById(R.id.radioButtonSetTempMesurFahren);
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

    private void rapidlySetRadiobuttons() {
        if (instance.getTemperatureMesur().equals("c")) {
            radioButtonSetTempMesurCelcium.setChecked(true);
        } else if (instance.getTemperatureMesur().equals("f"))
            radioButtonSetTempMesurCelcium.setChecked(true);
   }

    public void onCheckBoxTempMesurClicked(View view) {
        RadioButton clickedRadioButton = (RadioButton) view;
        boolean checked = clickedRadioButton.isChecked();
        switch (view.getId()) {
            case R.id.radioButtonSetTempMesurCelcium:
                if (checked) {
                    instance.setTemperatureMesur("c");
                }break;
            case R.id.radioButtonSetTempMesurFahren:
                if (checked) {
                    instance.setTemperatureMesur("f");
                }break;
        }
    }

    private void makeToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d(MY_LOG, msg);
    }
}
