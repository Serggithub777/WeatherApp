package com.example.weatherapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.SaveParametrs;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsAddFragment extends Fragment {
    public static final String ENABLED = "Enabled";
    public static final String DISABLED = "Disabled";
    private String checkBoxShowWindEnabled;
    private String checkBoxShowPressureEnabled;
    private String checkBoxShowRainProbablyEnabled;
    private String temperatureMesur;
    private CheckBox checkBoxWindSpeed;
    private CheckBox checkBoxAirPressure;
    private CheckBox checkBoxRainPossibility;
    private RadioGroup radioButtonsSetTempMesur;
    private RadioButton radioButtonSetTempMesurCelcium;
    private RadioButton radioButtonSetTempMesurFahren;

    public SettingsAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingsAddFragment =inflater.inflate(R.layout.fragment_add_settings, container,false);
        return settingsAddFragment;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkBoxWindSpeed = view.findViewById(R.id.checkBoxShowWind);
        onCheckBoxWindSpeedClicked(checkBoxWindSpeed);
        checkBoxAirPressure = view.findViewById(R.id.checkBoxShowPressure);
        onCheckBoxAirPressureClicked(checkBoxAirPressure);
        checkBoxRainPossibility = view.findViewById(R.id.checkBoxShowRainProbably);
        onCheckBoxRainPossibilityClicked(checkBoxRainPossibility);

    }


    private void onCheckBoxWindSpeedClicked(CheckBox checkBoxWindSpeed) {

        if (checkBoxWindSpeed.isChecked()){
            checkBoxShowWindEnabled = ENABLED;
        } else checkBoxShowWindEnabled = DISABLED;
    }
    private void onCheckBoxAirPressureClicked(CheckBox checkBoxAirPressure) {
        if (checkBoxAirPressure.isChecked()) {
            checkBoxShowPressureEnabled = ENABLED;
        } else checkBoxShowPressureEnabled = DISABLED;
    }
    private void onCheckBoxRainPossibilityClicked(CheckBox checkBoxRainPossibility) {
        if (checkBoxRainPossibility.isChecked()) {
            checkBoxShowRainProbablyEnabled = ENABLED;
        } else checkBoxShowRainProbablyEnabled = DISABLED;
    }

    private void onRadioButtonClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.radioButtonSetTempMesurCelcium:
                if (checked) {
                    temperatureMesur = "C";
                }break;
            case R.id.radioButtonSetTempMesurFahren:
                if (checked) {
                    temperatureMesur = "F";
                }break;
        }
    }
}
