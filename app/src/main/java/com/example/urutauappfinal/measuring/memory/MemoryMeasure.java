package com.example.urutauappfinal.measuring.memory;

import com.example.urutauappfinal.measuring.Measure;

public class MemoryMeasure extends Measure{
    private final long totalMemory, freeMemory; // bytes

    public static int cont = 0;
    public static long mediaMemory = 0;

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

    public static long mediaMemory(long totalMemory, boolean estado){
        mediaMemory += totalMemory;
        cont++;
        if(estado == false){
            return mediaMemory/cont;
        }else{
            cont = 0;
            mediaMemory = 0;
            return 0;
        }

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
