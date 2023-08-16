package com.example.urutauappfinal.measuring;

import android.content.Context;

import java.util.LinkedList;

public class MonitorThread extends Thread {
    private final Context context;
    private final MeasureFactory mf;
    private boolean mRunning;

    private final LinkedList<GeneralMeasure> memEnVals;

    public MonitorThread(Context context) {
        this.context = context;
        this.mf = new MeasureFactory(context);
        this.mRunning = false;
        memEnVals = new LinkedList<>();
    }

    @Override
    public void run() {
        mRunning = true;
        while(mRunning) {
            try {
                sleep(MeasureFactory.MEASUREMENT_INTERVAL_MS);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            memEnVals.add(mf.getMemoryAndEnergy());
        }
    }

    public void stopMonitoring() {
        mRunning = false;
    }

    public LinkedList<GeneralMeasure> getMemEnVals() {
        return memEnVals;
    }
}