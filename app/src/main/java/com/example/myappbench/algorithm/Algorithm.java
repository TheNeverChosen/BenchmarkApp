package com.example.benchmarkapp.algorithm;

import com.example.benchmarkapp.measure.Benchmark;

public abstract class Algorithm {
    //runs the algorithm. Returns a Benchmark detailing the execution (time, memory, energy/battery)
    public abstract Benchmark run();
}
