package com.example.myappbench.algorithm.c;

public class CAlgorithms{
    static {
        System.loadLibrary("myappbench");
    }

    public static native int cPidigits(int var1);

    public static native int cFannkuch(int var1);

    public static native int cBinaryTrees(int var1);

    public static native int cNbody(int var1);
}
