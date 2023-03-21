package com.example.benchmarkapp.measure.memory;

public class MemoryMeasure{
    public long time; // ms
    public long totalMemory, freeMemory; // bytes

    public MemoryMeasure(long time, long totalMemory, long freeMemory){
        this.time = time;
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
    }

    @Override
    public String toString(){
        return "MemoryMeasure{" +
                "time=" + time +
                ", totalMemory=" + totalMemory +
                ", freeMemory=" + freeMemory +
                '}';
    }
}
