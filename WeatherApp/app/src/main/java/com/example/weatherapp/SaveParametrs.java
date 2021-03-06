package com.example.weatherapp;

public final class SaveParametrs {
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
}
