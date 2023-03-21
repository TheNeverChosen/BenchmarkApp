package com.example.benchmarkapp.measure.energy;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.SystemClock;

import java.util.ArrayList;

public class BatteryMonitorThread extends Thread {
    private static final long MEASUREMENT_INTERVAL_MS = 100; // Measure every 1/10 second
    private final Context context;
    private final BatteryManager mBatteryManager;
    private boolean mRunning;
//    private double mTotalEnergyConsumed = 0;

    private ArrayList<EnergyMeasure> energyVals;

    public BatteryMonitorThread(Context context) {
        this.context = context;
        mBatteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
    }

    public synchronized void start(ArrayList<EnergyMeasure> values) {
        super.start();
    }

    @Override
    public void run() {
        mRunning = true;
        long lastMeasurementTime = SystemClock.elapsedRealtime();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        while(mRunning) {
            long currentTime = SystemClock.elapsedRealtime();
            Intent intent = context.registerReceiver(null, intentFilter);

            //https://developer.android.com/reference/android/os/BatteryManager#BATTERY_PROPERTY_CURRENT_NOW
            double voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);

            //https://developer.android.com/reference/android/os/BatteryManager#EXTRA_VOLTAGE
            double current = mBatteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW);

//            double power = current * voltage / 1000.0; // in watts
//            double energy = power * elapsedTime / 3600.0f; // in watt-hours
//            mTotalEnergyConsumed += energy;

            energyVals.add(new EnergyMeasure(currentTime, voltage, current));
            lastMeasurementTime = currentTime;

            try {
                Thread.sleep(MEASUREMENT_INTERVAL_MS);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopMonitoring() {
        mRunning = false;
    }

    public ArrayList<EnergyMeasure> getEnergyVals() {
        return energyVals;
    }
}