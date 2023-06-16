package com.example.urutauappfinal.measuring.memory;

import com.example.urutauappfinal.measuring.Measure;

public class MemoryMeasure extends Measure{
    private final long memoryHeapJava, memoryNative,memoryOthers; // bytes


    public MemoryMeasure(long time, long memoryHeapJava,long memoryNative,long memoryOthers){
        super(time);
        this.memoryHeapJava = memoryHeapJava;
        this.memoryNative = memoryNative;
        this.memoryOthers = memoryOthers;
    }

    //Total Memory in bytes

    public long getMemoryHeapJava(){
        return memoryHeapJava;
    }

    public long getMemoryNative(){
        return memoryNative;
    }

    public long getMemoryOthers(){
        return memoryOthers;
    }

}
