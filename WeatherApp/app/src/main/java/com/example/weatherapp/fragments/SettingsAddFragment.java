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
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        radioButtonsSetTempMesur = view.findViewById(R.id.radioGroupSetTempMesur);
        onRadioButtonClicked(radioButtonsSetTempMesur);
    }


    private void onCheckBoxWindSpeedClicked(CheckBox checkBoxWindSpeed) {
        checkBoxWindSpeed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxShowWindEnabled = ENABLED;
                    getToast("wind speed " + checkBoxShowWindEnabled);
                } else checkBoxShowWindEnabled = DISABLED;
                getToast("wind speed " + checkBoxShowWindEnabled);
            }
        });

   }
    private void onCheckBoxAirPressureClicked(CheckBox checkBoxAirPressure) {
        checkBoxAirPressure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxShowPressureEnabled = ENABLED;
                    getToast("air pressure " + checkBoxShowPressureEnabled);
                } else checkBoxShowPressureEnabled = DISABLED;
                getToast("air pressure " + checkBoxShowPressureEnabled);
            }
        });

    }
    private void onCheckBoxRainPossibilityClicked(CheckBox checkBoxRainPossibility) {
        checkBoxRainPossibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxShowRainProbablyEnabled = ENABLED;
                    getToast("rain possibility " + checkBoxShowRainProbablyEnabled);
                } else checkBoxShowRainProbablyEnabled = DISABLED;
                getToast("rain possibility " + checkBoxShowRainProbablyEnabled);
            }
        });

    }

    private void onRadioButtonClicked(RadioGroup radioGroup) {
       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId) {
                   case R.id.radioButtonSetTempMesurCelcium:
                       temperatureMesur = "C";
                       getToast(temperatureMesur);
                       break;
                   case R.id.radioButtonSetTempMesurFahren:
                       temperatureMesur = "F";
                       getToast(temperatureMesur);
                       break;
               }
           }
       });
    }

    private void getToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
