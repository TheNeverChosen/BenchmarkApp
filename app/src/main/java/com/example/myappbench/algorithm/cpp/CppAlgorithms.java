package com.example.myappbench.algorithm.cpp;

public class CppAlgorithms{
    static {
        System.loadLibrary("myappbench");
    }

    public static native int cppPidigits(int var1);

    public static native int cppFannkuch(int var1);

    public static native int cppBinaryTrees(int var1);

    public static native int cppNbody(int var1);
}
