package com.example.weatherapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.aktivities.SecondActivity;

import java.util.Objects;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout viewRecentCitiesLinearLayout = view.findViewById(R.id.recent_cities_List_linear_layout);
        initListRecentCities(viewRecentCitiesLinearLayout);
    }

    private void initListRecentCities(LinearLayout viewRecentCitiesLinearLayout) {
        String[] recentCities = getResources().getStringArray(R.array.recentCities);
        LayoutInflater layoutInflater = getLayoutInflater();

        for (int i = 0; i < recentCities.length; i++) {
            final String city = recentCities[i];
            View viewRecentCityItem = layoutInflater.inflate(R.layout.recent_city_list_item,
                    viewRecentCitiesLinearLayout, false);
            TextView textView = viewRecentCityItem.findViewById(R.id.textViewRecentCityItem);
            textView.setText(city);
            viewRecentCitiesLinearLayout.addView(viewRecentCityItem);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText cityName = Objects.requireNonNull(getView()).
                            findViewById(R.id.editTextEnterCity);
                    cityName.setText(city);
                }
            });

        }
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
