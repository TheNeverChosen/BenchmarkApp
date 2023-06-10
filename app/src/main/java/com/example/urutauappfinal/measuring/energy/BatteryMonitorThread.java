package com.example.urutauappfinal.measuring.energy;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.example.urutauappfinal.measuring.MeasureFactory;

import java.util.LinkedList;

public class BatteryMonitorThread extends Thread {
    private final Context context;
    private final MeasureFactory mf;
    private boolean mRunning;

    private final LinkedList<EnergyMeasure> energyVals;

    public BatteryMonitorThread(Context context) {
        this.context = context;
        this.mf = new MeasureFactory(context);
        this.mRunning = false;
        this.energyVals = new LinkedList<>();
    }

    @Override
    public void run() {
        mRunning = true;
        while(mRunning) {
            energyVals.add(mf.getEnergy());
            try {
                sleep(MeasureFactory.MEASUREMENT_INTERVAL_MS);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopMonitoring() {
        mRunning = false;
    }

    public LinkedList<EnergyMeasure> getEnergyVals() {
        return energyVals;
    }
}