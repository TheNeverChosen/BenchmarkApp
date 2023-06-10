package com.example.urutauappfinal.benchmarking;

import android.content.Context;
import android.util.Log;

import com.example.urutauappfinal.algorithms.java.JavaBinaryTrees;
import com.example.urutauappfinal.algorithms.java.JavaFannkuch;
import com.example.urutauappfinal.algorithms.java.JavaFasta;
import com.example.urutauappfinal.algorithms.java.JavaNBody;
import com.example.urutauappfinal.algorithms.java.JavaPiDigits;
import com.example.urutauappfinal.algorithms.c.CAlgorithms;
import com.example.urutauappfinal.algorithms.cpp.CppAlgorithms;
import com.example.urutauappfinal.algorithms.kotlin.KtBinaryTrees;
import com.example.urutauappfinal.algorithms.kotlin.KtFannkuch;
import com.example.urutauappfinal.algorithms.kotlin.KtFasta;
import com.example.urutauappfinal.algorithms.kotlin.KtNBody;
import com.example.urutauappfinal.algorithms.kotlin.KtPiDigits;
import com.example.urutauappfinal.algorithms.python.PyAlgorithms;
import com.example.urutauappfinal.measuring.MeasureFactory;
import com.example.urutauappfinal.measuring.energy.BatteryMonitorThread;
import com.example.urutauappfinal.measuring.memory.MemoryMonitorThread;

public class Benchmark{
    public enum Language{
        C,
        CPP,
        GO,
        JAVA,
        KOTLIN,
        PYTHON,
        RUST
    }
    public enum Algorithm{
        BINARY_TREES,
        FANNKUCH,
        FASTA,
        NBODY,
        PI_DIGITS
    }

    private final Context context;
    private MemoryMonitorThread memThread;
    private BatteryMonitorThread batThread;
    private long timeStart, timeEnd;

    public Benchmark(Context context){
        this.context = context;
    }

    private void startNewMonitoring(){
        memThread = new MemoryMonitorThread();
        batThread = new BatteryMonitorThread(context);
        memThread.start(); batThread.start();
        timeStart = MeasureFactory.getTime();
    }

    private void terminateMonitoring(){
        timeEnd = MeasureFactory.getTime();
        if(memThread!=null) memThread.stopMonitoring();
        if(batThread!=null) batThread.stopMonitoring();
    }


    private BenchmarkData execC(Algorithm algo, Object[] args){
        startNewMonitoring();
        switch(algo){
            case BINARY_TREES:
                CAlgorithms.cBinaryTreesRun((Integer) args[0]); break;
            case FANNKUCH:
                CAlgorithms.cFannkuchRun((Integer) args[0]); break;
            case FASTA:
                CAlgorithms.cFastaRun((Integer) args[0]); break;
            case NBODY:
                CAlgorithms.cNBodyRun((Integer) args[0]); break;
            case PI_DIGITS:
                CAlgorithms.cPiDigitsRun((Integer) args[0]); break;
            default: break;
        }
        terminateMonitoring();

        return new BenchmarkData(timeStart, timeEnd, memThread.getMemoryVals(), batThread.getEnergyVals());
    }

    private BenchmarkData execCpp(Algorithm algo, Object[] args){
        startNewMonitoring();
        switch(algo){
            case BINARY_TREES:
                CppAlgorithms.cppBinaryTreesRun((Integer) args[0]); break;
            case FANNKUCH:
                CppAlgorithms.cppFannkuchRun((Integer) args[0]); break;
            case FASTA:
                CppAlgorithms.cppFastaRun((Integer) args[0]); break;
            case NBODY:
                CppAlgorithms.cppNBodyRun((Integer) args[0]); break;
            case PI_DIGITS:
                CppAlgorithms.cppPiDigitsRun((Integer) args[0]); break;
            default: break;
        }
        terminateMonitoring();

        return new BenchmarkData(timeStart, timeEnd, memThread.getMemoryVals(), batThread.getEnergyVals());
    }

    private BenchmarkData execJava(Algorithm algo, Object[] args){
        startNewMonitoring();
        switch(algo){
            case BINARY_TREES:
                try{
                    JavaBinaryTrees.jvBinaryTreesRun((Integer) args[0]);
                } catch(Exception e){
                    Log.e("TREE ERROR", e.getMessage());
                }
                break;
            case FANNKUCH:
                JavaFannkuch.jvFannkuchRun((Integer) args[0]); break;
            case FASTA:
                JavaFasta.jvFastaRun((Integer) args[0]); break;
            case NBODY:
                JavaNBody.jvNBodyRun((Integer) args[0]); break;
            case PI_DIGITS:
                JavaPiDigits.jvPiDigitsRun((Integer) args[0]); break;
            default: break;
        }
        terminateMonitoring();

        return new BenchmarkData(timeStart, timeEnd, memThread.getMemoryVals(), batThread.getEnergyVals());
    }

    private BenchmarkData execKotlin(Algorithm algo, Object[] args){
        startNewMonitoring();
        switch(algo){
            case BINARY_TREES:
                try{
                    KtBinaryTrees.ktBinaryTreesRun((Integer) args[0]);
                } catch(Exception e){
                    Log.e("TREE ERROR", e.getMessage());
                }
                break;
            case FANNKUCH:
                KtFannkuch.run((Integer) args[0]); break;
            case FASTA:
                KtFasta.run((Integer) args[0]); break;
            case NBODY:
                KtNBody.run((Integer) args[0]); break;
            case PI_DIGITS:
                KtPiDigits.run((Integer) args[0]); break;
            default: break;
        }
        terminateMonitoring();

        return new BenchmarkData(timeStart, timeEnd, memThread.getMemoryVals(), batThread.getEnergyVals());
    }

    private BenchmarkData execRust(Algorithm algo, Object[] args){
        return null;
    }
    private BenchmarkData execPython(Algorithm algo, Object[] args){
        startNewMonitoring();
        switch(algo){
            case BINARY_TREES:
                PyAlgorithms.pyBinaryTreesRun((Integer) args[0]); break;
            case FANNKUCH:
                PyAlgorithms.pyFannkuchRun((Integer) args[0]); break;
            case FASTA:
                PyAlgorithms.pyFastaRun((Integer) args[0]); break;
            case NBODY:
                PyAlgorithms.pyNBodyRun((Integer) args[0]); break;
            case PI_DIGITS:
               PyAlgorithms.pyPiDigitsRun((Integer) args[0]); break;
            default: break;
        }
        terminateMonitoring();

        return new BenchmarkData(timeStart, timeEnd, memThread.getMemoryVals(), batThread.getEnergyVals());
    }

    public BenchmarkData execute(Language lang, Algorithm algo, Object[] args){
        switch(lang){
            case JAVA: return execJava(algo, args);
            case KOTLIN: return execKotlin(algo, args);
            case C: return execC(algo, args);
            case CPP: return execCpp(algo, args);
            case RUST: return execRust(algo, args);
            case PYTHON: return execPython(algo, args);
            default: return null;
        }
    }
}
