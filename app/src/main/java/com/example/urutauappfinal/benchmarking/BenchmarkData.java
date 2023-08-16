package com.example.urutauappfinal.benchmarking;

import androidx.annotation.NonNull;

import com.example.urutauappfinal.measuring.GeneralMeasure;

import java.util.LinkedList;

public class BenchmarkData{
    private final long timeStart, timeEnd; //in ms (1/1000s)
    private final LinkedList<GeneralMeasure> memEnLs;
    public BenchmarkData(long timeStart, long timeEnd,LinkedList<GeneralMeasure> memEnLs){
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.memEnLs = memEnLs;
        trimLs();
    }
    public LinkedList<GeneralMeasure> getMemEnLs(){
        return memEnLs;
    }

    //remove measures that are not in the time range
    public void trimLs(){
        if(memEnLs == null || memEnLs.size() == 0) return;

        //remove energy measures that are not in the time range
        while(memEnLs.getFirst().getTime() < timeStart) memEnLs.removeFirst();
        while(memEnLs.getLast().getTime() > timeEnd) memEnLs.removeLast();
    }

    
    public long getTimeStart(){
        return timeStart;
    }

    public long getTimeEnd(){
        return timeEnd;
    }

    @Override
    public String toString() {
        return "BenchmarkData{ " + (timeEnd-timeStart)+"ms }\n";
    }
}
