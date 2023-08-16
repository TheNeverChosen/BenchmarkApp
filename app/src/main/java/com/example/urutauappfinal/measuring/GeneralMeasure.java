package com.example.urutauappfinal.measuring;

import com.example.urutauappfinal.measuring.Measure;

public class GeneralMeasure extends Measure{
    private final long memoryOthers,memoryHeapJava,memoryNative, memoryCode, memoryStack; // bytes
    private final double voltage, current; //millivolts, micro-amperes


    public GeneralMeasure(long time, long memoryOthers, long memoryHeapJava, long memoryNative, long memoryCode, long memoryStack,double current,double voltage){
        super(time);
        this.memoryOthers = memoryOthers;
        this.memoryHeapJava = memoryHeapJava;
        this.memoryNative = memoryNative;
        this.memoryCode = memoryCode;
        this.memoryStack = memoryStack;
        this.voltage = voltage;
        this.current = Math.abs(current);
    }

    public long getMemoryOthers() {
        return memoryOthers;
    }

    public long getMemoryHeapJava() {
        return memoryHeapJava;
    }

    public long getMemoryNative() {
        return memoryNative;
    }

    public long getMemoryCode() {
        return memoryCode;
    }

    public long getMemoryStack() {
        return memoryStack;
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
}
