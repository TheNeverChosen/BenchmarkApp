package com.example.benchmarkapp.algorithm.compat.PiDigits;

import com.example.benchmarkapp.algorithm.code.java.PiBenchGameJava;

public class JavaPiDigits extends PiDigits{
    public JavaPiDigits(int n) {
        super(n);
    }

    @Override
    public void run() {
        PiBenchGameJava.pidigitsjv(n);
    }
}
