package com.example.urutauappfinal.measuring.memory;

import com.example.urutauappfinal.measuring.Measure;

public class MemoryMeasure extends Measure{
    private final long totalMemory, freeMemory, memoryNative,memoryOthers; // bytes


    public MemoryMeasure(long time, long totalMemory, long freeMemory,long memoryNative,long memoryOthers){
        super(time);
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.memoryNative = memoryNative;
        this.memoryOthers = memoryOthers;
    }

    //Total Memory in bytes
    public long getTotalMemory(){
        return totalMemory;
    }

    //Free Memory in bytes
    public long getFreeMemory(){
        return freeMemory;
    }

    public long getMemoryNative(){
        return memoryNative;
    }

    public long getMemoryOthers(){
        return memoryOthers;
    }

}
