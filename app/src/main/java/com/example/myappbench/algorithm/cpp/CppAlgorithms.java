package com.example.myappbench.algorithm.cpp;

public class CppAlgorithms{
    static {
        System.loadLibrary("bench_cpp");
    }

    public static native void cppPiDigitsRun(int num);

    public static native void cppFannkuchRun(int num);

    public static native void cppBinaryTreesRun(int num);

    public static native void cppNBodyRun(int num);
}
