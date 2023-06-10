package com.example.urutauappfinal.algorithms.c;

public class CAlgorithms{
    static {
        System.loadLibrary("bench_c");
    }

    public static native int cPiDigitsRun(int num);
    public static native int cFannkuchRun(int num);
    public static native int cBinaryTreesRun(int num);
    public static native int cNBodyRun(int num);
    public static native int cFastaRun(int num);
}
