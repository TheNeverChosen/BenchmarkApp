package com.example.benchmarkapp.algorithm.compat.PiDigits;

import com.example.benchmarkapp.algorithm.code.kotlin.PiBenchGameKt;

public class KtPiDigits extends PiDigits {
    public KtPiDigits(int n) {
        super(n);
    }

    @Override
    public void run() {
        new PiBenchGameKt().run(n);
    }
}
