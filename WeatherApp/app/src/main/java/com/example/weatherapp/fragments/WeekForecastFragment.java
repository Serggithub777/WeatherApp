package com.example.weatherapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeekForecastFragment extends Fragment {

    public WeekForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
  View weekForecastFrgment = inflater.inflate(R.layout.fragment_week_forecast, container, false);
        return weekForecastFrgment;
    }
}
