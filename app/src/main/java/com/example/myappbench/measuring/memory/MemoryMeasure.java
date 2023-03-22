package com.example.myappbench.measuring.memory;

import com.example.myappbench.measuring.Measure;
import com.example.myappbench.measuring.MeasureFactory;

public class MemoryMeasure extends Measure{
    private final long totalMemory, freeMemory; // bytes

    public MemoryMeasure(long time, long totalMemory, long freeMemory){
        super(time);
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
    }

    //Total Memory in bytes
    public long getTotalMemory(){
        return totalMemory;
    }

    //Free Memory in bytes
    public long getFreeMemory(){
        return freeMemory;
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
