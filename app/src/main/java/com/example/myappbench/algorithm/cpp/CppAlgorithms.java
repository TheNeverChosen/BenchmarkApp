package com.example.myappbench.algorithm.cpp;

public class CppAlgorithms{
    static {
        System.loadLibrary("bench_cpp");
    }

    public static native void cppPidigits(int var1);

    public static native void cppFannkuch(int var1);

    public static native void cppBinaryTrees(int var1);

    public static native void cppNbody(int var1);
}
