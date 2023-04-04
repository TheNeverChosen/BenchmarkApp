package com.example.myappbench.algorithm.c;

public class CAlgorithms{
    static {
        System.loadLibrary("bench_c");
    }

    public static native void cPidigits(int var1);

    public static native void cFannkuch(int var1);

    public static native void cBinaryTrees(int var1);

    public static native void cNbody(int var1);
}
