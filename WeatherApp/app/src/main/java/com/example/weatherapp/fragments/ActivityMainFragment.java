package com.example.weatherapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.aktivities.SecondActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityMainFragment extends Fragment {
    private EditText editTextEnterCityName;
    private Button buttonShowWeather;
    private Button buttonSettings;
    private View.OnClickListener onShowWeatherButtonClick;
    private View.OnClickListener onSettingsButtonClick;

    public ActivityMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View activityMainFragment = inflater.inflate(R.layout.fragment_activity_main, container, false);
        editTextEnterCityName = activityMainFragment.findViewById(R.id.editTextEnterCity);
        buttonShowWeather = activityMainFragment.findViewById(R.id.buttonShowWeather);
        buttonSettings = activityMainFragment.findViewById(R.id.buttonSettings);

        createButtonShowWeatherListener();
        buttonShowWeather.setOnClickListener(onShowWeatherButtonClick);
        createButtonSettingsListener();
        buttonSettings.setOnClickListener(onSettingsButtonClick);

        return activityMainFragment;
    }



    private void createButtonShowWeatherListener() {
        onShowWeatherButtonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName =  editTextEnterCityName.getText().toString().trim();
                if (cityName.isEmpty()) {
                    Toast.makeText(getContext(), "Enter City Name!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), SecondActivity.class);
                    intent.putExtra("CITY_NAME",cityName);
                    startActivity(intent);
                }

            }
        };
    }

    private void createButtonSettingsListener() {
        onSettingsButtonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_activity_container, new SettingsAddFragment());
                ft.addToBackStack(null);
                ft.commit();

            }
        };
    }

}
