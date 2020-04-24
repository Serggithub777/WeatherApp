package com.example.weatherapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityMainFragment extends Fragment {
    private EditText editTextEnterCityName;
    private View.OnClickListener onShowWeatherButtonClick;
    private View.OnClickListener onSettingsButtonClick;

    public ActivityMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View activityMainFragment = inflater.inflate(R.layout.fragment_activity_main, container, false);

        return activityMainFragment;
    }


}
