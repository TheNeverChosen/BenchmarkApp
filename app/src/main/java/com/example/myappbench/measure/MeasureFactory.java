package com.example.benchmarkapp.measure;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.SystemClock;

import com.example.benchmarkapp.measure.energy.EnergyMeasure;
import com.example.benchmarkapp.measure.memory.MemoryMeasure;

public class MeasureFactory {
    //COMMON
    public static final long MEASUREMENT_INTERVAL_MS = 100; // Measures every 1/10 second

    //ENERGY
    private final static IntentFilter INTENT_BATTERY_FILTER = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    private final Context context;
    private final BatteryManager batteryManager;

    public MeasureFactory(Context context){
        this.context = context;
        this.batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
    }

    public static long getTime(){
        return SystemClock.elapsedRealtime(); //ms
    }

    public EnergyMeasure getEnergy(){
        Intent intent = context.registerReceiver(null, INTENT_BATTERY_FILTER);
        long time = getTime(); //ms
        double voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1); //millivolts
        double current = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW); //micro-amperes

        return new EnergyMeasure(time, voltage, current);
    }

    public MemoryMeasure getMemory(){
        long time = getTime(); //ms
        long totalMemory = Runtime.getRuntime().totalMemory(); //bytes
        long freeMemory = Runtime.getRuntime().freeMemory(); //bytes

        return new MemoryMeasure(time, totalMemory, freeMemory);
    }
}
