package com.example.myappbench.measuring.energy;

import android.content.Intent;
import android.content.IntentFilter;

import com.example.myappbench.measuring.Measure;

public class EnergyMeasure extends Measure{
    private final double voltage, current; //millivolts, micro-amperes

    public EnergyMeasure(long time, double voltage, double current){
        super(time);
        this.time = time;
        this.voltage = voltage;
        this.current = Math.abs(current);
    }

    //voltage in millivolts
    public double getVoltage(){
        return voltage;
    }

    //voltage in Volts
    public double getVoltageVolt(){
        return voltage / 1e3;
    }

    //current in micro-amperes
    public double getCurrent(){
        return current;
    }

    //current in Amperes
    public double getCurrentAmpere(){
        return current / 1e6;
    }

    //Power in Watt * 10^9
    public double getPower(){
        return voltage*current;
    }

    //Power in Watt
    public double getPowerWatt(){
        return getPower()/1e9;
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
