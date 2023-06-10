package com.example.urutauappfinal.measuring;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.SystemClock;
import com.example.urutauappfinal.collectionFiles.EscritorDeArquivo;
import android.util.Log;

import com.example.urutauappfinal.measuring.energy.EnergyMeasure;
import com.example.urutauappfinal.measuring.memory.MemoryMeasure;

public class MeasureFactory {
    //COMMON
    public static final long MEASUREMENT_INTERVAL_MS = 100; // Measures every 1/10 second

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

    public static MemoryMeasure getMemory(){
        long time = getTime(); //ms
        long totalMemory = Runtime.getRuntime().totalMemory(); //bytes
        long freeMemory = Runtime.getRuntime().freeMemory(); //bytes

        String tempo = "Time: " + time + "\n";
        String memoriaT = "Memoria Total: " + totalMemory + "\n";
        String memoriaF = "Memoria Livre: " + freeMemory + "\n";

        //Log.i("Dados Memoria: ", tempo + memoriaT + memoriaF);

        MemoryMeasure.mediaMemory(totalMemory, false);

        return new MemoryMeasure(time, totalMemory, freeMemory);
    }

    public EnergyMeasure getEnergy(){
        Intent intent = context.registerReceiver(null, INTENT_BATTERY_FILTER);
        long time = getTime(); //ms

        //https://developer.android.com/reference/android/os/BatteryManager#EXTRA_VOLTAGE
        double voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1); //millivolts

        //https://developer.android.com/reference/android/os/BatteryManager#BATTERY_PROPERTY_CURRENT_NOW
        double current = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW); //micro-amperes

        String tempo = "Time: " + time + "\n";
        String tensao = "Voltage: " + voltage + "\n";
        String corrente = "Corrente: " + current + "\n";

        //Log.i("Dados Energia: ", tempo + tensao + corrente);

        return new EnergyMeasure(time, voltage, current);
    }
}
