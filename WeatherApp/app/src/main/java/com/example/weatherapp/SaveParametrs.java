package com.example.weatherapp;

import android.os.Parcel;
import android.os.Parcelable;

public final class SaveParametrs implements Parcelable {
    public static final String MY_LOG = "MyLog";
    public static final String ENABLED = "Enabled";
    public static final String DISABLED = "Disabled";
    private static SaveParametrs instance = null;
    private static final Object syncObj = new Object();
    private String checkBoxShowWindEnabled;
    private String checkBoxShowPressureEnabled;
    private String checkBoxShowRainProbablyEnabled;
    private String temperatureMesur;

    private SaveParametrs() {

    }

    protected SaveParametrs(Parcel in) {
        checkBoxShowWindEnabled = in.readString();
        checkBoxShowPressureEnabled = in.readString();
        checkBoxShowRainProbablyEnabled = in.readString();
        temperatureMesur = in.readString();
    }

    public static final Creator<SaveParametrs> CREATOR = new Creator<SaveParametrs>() {
        @Override
        public SaveParametrs createFromParcel(Parcel in) {
            return new SaveParametrs(in);
        }

        @Override
        public SaveParametrs[] newArray(int size) {
            return new SaveParametrs[size];
        }
    };

    public String getTemperatureMesur() {
        return temperatureMesur;
    }

    public void setTemperatureMesur(String set) {
        this.temperatureMesur = set;
    }




    public String getCheckBoxShowWindEnabled() {
        return checkBoxShowWindEnabled;
    }

    public void setCheckBoxShowWindEnabled(String checkBoxShowWindEnabled) {
        this.checkBoxShowWindEnabled = checkBoxShowWindEnabled;
    }

    public String getCheckBoxShowPressureEnabled() {
        return checkBoxShowPressureEnabled;
    }

    public void setCheckBoxShowPressureEnabled(String checkBoxShowPressureEnabled) {
        this.checkBoxShowPressureEnabled = checkBoxShowPressureEnabled;
    }

    public String getCheckBoxShowRainProbablyEnabled() {
        return checkBoxShowRainProbablyEnabled;
    }

    public void setCheckBoxShowRainProbablyEnabled(String checkBoxShowRainProbablyEnabled) {
        this.checkBoxShowRainProbablyEnabled = checkBoxShowRainProbablyEnabled;
    }



    public static SaveParametrs getInstance() {
        synchronized (syncObj) {
            if (instance == null) {
                instance = new SaveParametrs();
            }
        }return instance;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(checkBoxShowWindEnabled);
        dest.writeString(checkBoxShowPressureEnabled);
        dest.writeString(checkBoxShowRainProbablyEnabled);
        dest.writeString(temperatureMesur);
    }
}
