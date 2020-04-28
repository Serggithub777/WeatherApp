package com.example.weatherapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.R;
import com.example.weatherapp.WeatherAppAdapterRecycler;

import java.util.Objects;


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

        String[] daysOfWeekArrays = getResources().getStringArray(R.array.days_of_week);
        RecyclerView recyclerView = weekForecastFrgment.findViewById(R.id.recycler_view_week_forecast);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        WeatherAppAdapterRecycler adapterRecycler = new WeatherAppAdapterRecycler(daysOfWeekArrays);
        recyclerView.setAdapter(adapterRecycler);

        return weekForecastFrgment;
    }
}
