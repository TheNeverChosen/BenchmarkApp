package com.example.myappbench.algorithm.cpp;

public class CppAlgorithms{
    static {
        System.loadLibrary("bench_cpp");
    }

    public static native int cppPiDigitsRun(int num);
    public static native int cppFannkuchRun(int num);
    public static native int cppBinaryTreesRun(int num);
    public static native int cppNBodyRun(int num);
    public static native int cppFastaRun(int num);
}
