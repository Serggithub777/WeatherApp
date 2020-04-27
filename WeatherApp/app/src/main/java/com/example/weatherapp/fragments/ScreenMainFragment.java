package com.example.weatherapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weatherapp.R;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenMainFragment extends Fragment {
    private TextView textViewCityName;

    public ScreenMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View screenMainFragment = inflater.inflate(R.layout.fragment_main_screen, container, false);
        textViewCityName = screenMainFragment.findViewById(R.id.textViewCityName);

        return screenMainFragment;
    }

    public void setTextViewCityName(String cityName) {
        textViewCityName.setText(cityName);
    }
}
