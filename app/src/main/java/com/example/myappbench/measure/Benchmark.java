package com.example.benchmarkapp.measure;

import com.example.benchmarkapp.measure.energy.EnergyMeasure;
import com.example.benchmarkapp.measure.memory.MemoryMeasure;

import java.util.ArrayList;

public class Benchmark {
  long timeStart, timeEnd;
  ArrayList<EnergyMeasure> energyLs;
  ArrayList<MemoryMeasure> memLs;

  public Benchmark(long timeStart, long timeEnd, ArrayList<EnergyMeasure> energyLs, ArrayList<MemoryMeasure> memLs) {
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.energyLs = energyLs;
    this.memLs = memLs;
  }


  public double getTotalEnergy() {
    if(energyLs==null || energyLs.size()==0) return 0;

    double pastTime = energyLs.get(0).getTime(), pastPower = energyLs.get(0).getPower();
    
    //calculate using trapezoidal rule
    double totalEnergy=0;
    for(EnergyMeasure x : energyLs){
      double curTime = x.getTime();
      double curPower = x.getPower();
      totalEnergy += (curTime-pastTime) * (curPower+pastPower)/2.0;
      pastTime = curTime; pastPower = curPower;
    }

    //watt is measured in seconds. time in code is in ms. will it be a problem?  


    return totalEnergy/2.0; //trapezoidal rule
  }

  //Energy Watt
  public double getTotalEnergyWatt(){
    return getTotalEnergy()/1000000000.0;
  }

  //Energy Watt Hour
  public double getTotalEnergyWattHour() {
    return getTotalEnergyWatt() / 3600000000000.0;
  }

}
