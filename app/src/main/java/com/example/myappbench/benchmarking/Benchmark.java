package com.example.myappbench.benchmarking;

import android.content.Context;
import android.util.Log;

import com.example.myappbench.algorithm.java.BodyBenchGameJava;
import com.example.myappbench.algorithm.java.FannkuchBenchGameJava;
import com.example.myappbench.algorithm.java.PiBenchGameJava;
import com.example.myappbench.algorithm.kotlin.BodyBenchGameKt;
import com.example.myappbench.algorithm.kotlin.FannkuchBenchGameKt;
import com.example.myappbench.algorithm.kotlin.PiBenchGameKt;
import com.example.myappbench.algorithm.kotlin.TreeBenchGameKt;
import com.example.myappbench.measuring.MeasureFactory;
import com.example.myappbench.measuring.energy.BatteryMonitorThread;
import com.example.myappbench.measuring.memory.MemoryMonitorThread;


public class Benchmark{
    public enum Language{
        JAVA,
        KOTLIN,
        C,
        C_PLUS,
        RUST,
        PYTHON
    }
    public enum Algorithm{
        PI_DIGITS,
        FANNKUCH,
        TREE,
        BODY
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

    private BenchmarkData execJava(Algorithm algo, Object[] args){
        startNewMonitoring();
        switch(algo){
            case PI_DIGITS:
                PiBenchGameJava.pidigitsjv((Integer) args[0]);
                break;
            case FANNKUCH:
                FannkuchBenchGameJava.run((Integer) args[0]);
                break;
            case TREE:
                try{
                    TreeBenchGameKt.run((Integer) args[0]);
                } catch(Exception e){
                    Log.e("TREE ERROR", e.getMessage());
                }
                break;
            case BODY:
                BodyBenchGameJava.run((Integer) args[0]);
                break;
            default: break;
        }
        terminateMonitoring();

        return new BenchmarkData(timeStart, timeEnd, memThread.getMemoryVals(), batThread.getEnergyVals());
    }

    private BenchmarkData execKotlin(Algorithm algo, Object[] args){
        startNewMonitoring();
        switch(algo){
            case PI_DIGITS:
                PiBenchGameKt.run((Integer) args[0]); break;
            case FANNKUCH:
                new FannkuchBenchGameKt().run((Integer) args[0]); break;
            case TREE:
                try{
                    TreeBenchGameKt.run((Integer) args[0]);
                } catch(Exception e){
                    Log.e("TREE ERROR", e.getMessage());
                }
                break;
            case BODY:
                BodyBenchGameKt.run((Integer) args[0]); break;
            default: break;
        }
        terminateMonitoring();

        return new BenchmarkData(timeStart, timeEnd, memThread.getMemoryVals(), batThread.getEnergyVals());
    }

    private BenchmarkData execC(Algorithm algo, Object[] args){
        return null;
    }
    private BenchmarkData execCPlus(Algorithm algo, Object[] args){
        return null;
    }
    private BenchmarkData execRust(Algorithm algo, Object[] args){
        return null;
    }
    private BenchmarkData execPython(Algorithm algo, Object[] args){
        return null;
    }

    public BenchmarkData execute(Language lang, Algorithm algo, Object[] args){
        switch(lang){
            case JAVA: return execJava(algo, args);
            case KOTLIN: return execKotlin(algo, args);
            case C: return execC(algo, args);
            case C_PLUS: return execCPlus(algo, args);
            case RUST: return execRust(algo, args);
            case PYTHON: return execPython(algo, args);
            default: return null;
        }
    }
}
