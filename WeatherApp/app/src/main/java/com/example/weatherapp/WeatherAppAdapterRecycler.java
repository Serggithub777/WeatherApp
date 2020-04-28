package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherAppAdapterRecycler extends RecyclerView.Adapter<WeatherAppAdapterRecycler.ViewHolder> {

    private String[] daysOfWeekArray;

    public WeatherAppAdapterRecycler(String[] daysOfWeekArray) {
        this.daysOfWeekArray = daysOfWeekArray;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.weather_recycler_item, viewGroup, false);

        return new  ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(daysOfWeekArray[position]);

    }

    @Override
    public int getItemCount() {
        return daysOfWeekArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView dayOfWeek;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           dayOfWeek = itemView.findViewById(R.id.textViewItemDayOfWeek);
       }

        public TextView getTextView() {
            return dayOfWeek;
        }
    }
}
