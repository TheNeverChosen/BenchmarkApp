package com.example.benchmarkapp.measure.energy;

import android.content.Intent;
import android.content.IntentFilter;

public class EnergyMeasure{
    private final static IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    public long time; //ms
    public double voltage, current; //millivolts, micro-amperes

    public EnergyMeasure(long time, double voltage, double current){
        this.time = time;
        this.voltage = voltage;
        this.current = current;
    }

    //time in ms (1ms = 1/1000s)
    public long getTime(){
        return time;
    }

    //voltage in millivolts
    public double getVoltage(){
        return voltage;
    }

    //voltage in Volts
    public double getVoltageVolt(){
        return voltage / 1000.0;
    }

    //current in micro-amperes
    public double getCurrent(){
        return current;
    }

    //current in Amperes
    public double getCurrentAmpere(){
        return current / 1000000.0;
    }

    //Power in Watt * 10^9
    public double getPower(){
        return voltage*current;
    }

    //Power in Watt
    public double getPowerWatt(){
        return getPower()/1000000000.0;
    }

    @Override
    public String toString(){
        return "EnergyMeasure{" +
                "time=" + time +
                ", voltage=" + voltage +
                ", current=" + current +
                '}';
    }
}
