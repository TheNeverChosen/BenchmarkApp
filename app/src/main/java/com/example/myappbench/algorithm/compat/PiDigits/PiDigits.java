package com.example.benchmarkapp.algorithm.compat.PiDigits;

import com.example.benchmarkapp.algorithm.Algorithm;

public abstract class PiDigits extends Algorithm {
    protected int n; //number of Pi Digits to calculate

    public PiDigits(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }
}
