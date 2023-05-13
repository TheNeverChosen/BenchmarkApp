package com.example.myappbench.algorithm.c;

public class CAlgorithms{
    static {
        System.loadLibrary("bench_c");
    }

    public static native void cPiDigitsRun(int num);
    public static native void cFannkuchRun(int num);
    public static native void cBinaryTreesRun(int num);
    public static native void cNBodyRun(int num);
    public static native void cFastaRun(int num);
}
