package com.example.urutauappfinal.measuring;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Debug;
import android.os.SystemClock;

public class MeasureFactory {
    //COMMON
    public static final long MEASUREMENT_INTERVAL_MS = 100; // Measures every 1/10 second
    static Debug.MemoryInfo appMemoryInfo = new Debug.MemoryInfo();
    //MEMORY
    public static final long mb=1024*1024;

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

    public GeneralMeasure getMemoryAndEnergy(){
        long time = getTime(); //ms
        Debug.getMemoryInfo(appMemoryInfo);
        long memoryOthers = 0,memoryHeapJava = 0, memoryCode = 0, memoryStack = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            memoryOthers = Long.parseLong(appMemoryInfo.getMemoryStat("summary.private-other"))*1024;
            memoryHeapJava = Long.parseLong(appMemoryInfo.getMemoryStat("summary.java-heap"))*1024;
            memoryCode = Long.parseLong(appMemoryInfo.getMemoryStat("summary.code"))*1024;
            memoryStack = Long.parseLong(appMemoryInfo.getMemoryStat("summary.stack"))*1024;
        }
        long memoryNative = Debug.getNativeHeapAllocatedSize();
        //todos os dados de memória estão em bytes

        Intent intent = context.registerReceiver(null, INTENT_BATTERY_FILTER);

        //https://developer.android.com/reference/android/os/BatteryManager#EXTRA_VOLTAGE
        double voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1); //millivolts

        //https://developer.android.com/reference/android/os/BatteryManager#BATTERY_PROPERTY_CURRENT_NOW
        double current = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW); //micro-amperes
        //Log.i("voltage","voltage: "+voltage+ "mV e current: "+current+"A \n");

        return new GeneralMeasure(time, memoryOthers, memoryHeapJava, memoryNative, memoryCode, memoryStack,current,voltage);
    }
}
