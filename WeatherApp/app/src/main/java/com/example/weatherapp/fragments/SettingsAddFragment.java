package com.example.weatherapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weatherapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsAddFragment extends Fragment {

    public SettingsAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingsAddFragment =inflater.inflate(R.layout.fragment_add_settings, container,false);
        return settingsAddFragment;
    }
}
