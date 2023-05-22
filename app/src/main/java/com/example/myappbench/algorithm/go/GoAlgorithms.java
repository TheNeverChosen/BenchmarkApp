package com.example.myappbench.algorithm.go;

public class GoAlgorithms {

    static {
        System.loadLibrary("bench_go");
    }

    public static native void goPiDigitsRun(int num);
    public static native void goFannkuchRun(int num);
    public static native void goBinaryTreesRun(int num);
    public static native void goNBodyRun(int num);
    public static native void goFastaRun(int num);
}
