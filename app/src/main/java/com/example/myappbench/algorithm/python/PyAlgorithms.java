package com.example.myappbench.algorithm.python;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class PyAlgorithms {
    private final static Python python = Python.getInstance();
    private final static PyObject
        modBinTrees = python.getModule("pyBinaryTrees"),
        modFannkuch = python.getModule("pyFannkuch"),
        modFasta = python.getModule("pyFasta"),
        modNBody = python.getModule("pyNBody"),
        modPiDigits = python.getModule("pyPiDigits");

    public static void pyBinaryTreesRun(int num){
        modBinTrees.callAttr("pyBinaryTreesRun", num);
    }
    public static void pyFannkuchRun(int num){
        modFannkuch.callAttr("pyFannkuchRun", num);
    }
    public static void pyFastaRun(int num){
        modFasta.callAttr("pyFastaRun", num);
    }
    public static void pyNBodyRun(int num){
        modNBody.callAttr("pyNBody", num);
    }
    public static void pyPiDigitsRun(int num){
        modPiDigits.callAttr("pyPiDigitsRun", num);
    }

}
