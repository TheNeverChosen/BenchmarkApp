package com.example.myappbench.benchmarking;

import com.example.myappbench.measuring.energy.EnergyMeasure;
import com.example.myappbench.measuring.memory.MemoryMeasure;

import java.util.LinkedList;

public class BenchmarkData{
    private final long timeStart, timeEnd; //in ms (1/1000s)
    private final LinkedList<MemoryMeasure> memLs;
    private final LinkedList<EnergyMeasure> energyLs;

    public BenchmarkData(long timeStart, long timeEnd, LinkedList<MemoryMeasure> memLs, LinkedList<EnergyMeasure> energyLs){
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.energyLs = energyLs;
        this.memLs = memLs;

        trimEnergy(); trimMemory();
    }

    //remove energy measures that are not in the time range
    public void trimEnergy(){
        if(energyLs == null || energyLs.size() == 0) return;

        //remove energy measures that are not in the time range
        while(energyLs.getFirst().getTime() < timeStart) energyLs.removeFirst();
        while(energyLs.getLast().getTime() > timeEnd) energyLs.removeLast();
    }

    //remove memory measures that are not in the time range
    public void trimMemory(){
        if(memLs == null || memLs.size() == 0) return;

        //remove memory measures that are not in the time range
        while(memLs.getFirst().getTime() < timeStart) memLs.removeFirst();
        while(memLs.getLast().getTime() > timeEnd) memLs.removeLast();
    }

    //Total Energy in Joules * 10^12
    public double getTotalEnergy(){
        if(energyLs == null || energyLs.size() == 0) return 0;

        double pastTime = timeStart, //in ms (1/1000s)
          pastPower = energyLs.get(0).getPower(); //in Watt * 10^9

        //calculate using trapezoidal rule
        double totalEnergy = 0;
        for(EnergyMeasure x : energyLs){
            double curTime = x.getTime(); //in ms (1/1000s)
            double curPower = x.getPower(); //in Watt * 10^9
            totalEnergy += (curTime - pastTime) * (curPower + pastPower);
            pastTime = curTime;
            pastPower = curPower;
        }
        return totalEnergy / 2.0;
    }

    //Energy in Joules
    public double getTotalEnergyJoules(){
        return getTotalEnergy() / 1e12;
    }

    //Energy Watt Hour
    public double getTotalEnergyWattHour(){
        return getTotalEnergy() / 3.6e15;
    }
    
    public long getTimeStart(){
        return timeStart;
    }

    public long getTimeEnd(){
        return timeEnd;
    }

    public long getDuration(){
        return timeEnd - timeStart;
    }

    //tostring with time start, time end, duration, total energy joules, total energy watt hour
    @Override
    public String toString(){
        return "Time Start: " + timeStart + " ms" + 
          "\nTime End: " + timeEnd + " ms" + 
          "\nDuration: " + getDuration() + " ms" + 
          "\nTotal Energy (J): " + getTotalEnergyJoules() + " J" + 
          "\nTotal Energy (Wh): " + getTotalEnergyWattHour() + " Wh";
    }

}
