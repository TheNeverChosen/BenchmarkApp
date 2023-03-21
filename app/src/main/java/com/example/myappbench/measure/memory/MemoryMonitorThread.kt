package com.example.measureenergy.measure

import android.os.SystemClock
import com.example.benchmarkapp.measure.MeasureFactory
import com.example.benchmarkapp.measure.memory.MemoryMeasure

class MemoryMonitorThread : Runnable{
//    private val mb = 1024*1024
    private val memoryVals = ArrayList<MemoryMeasure>()

    override fun run() {
//        val initialUsedMemory = (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/mb;
        while(true) {
            
//            var usedMemoryCurrent = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
//                .freeMemory()) / mb - initialUsedMemory;

            val currentTime = SystemClock.elapsedRealtime();
            val totalMemory = Runtime.getRuntime().totalMemory();
            val freeMemory = Runtime.getRuntime().freeMemory();

            memoryVals.add(MemoryMeasure(currentTime, totalMemory, freeMemory));

            try {
                Thread.sleep(MeasureFactory.MEASUREMENT_INTERVAL_MS);
            }
            catch (e: InterruptedException){
                e.printStackTrace()
            }
        }
    }

    public fun getArrayMemory(): ArrayList<MemoryMeasure> {
        return memoryVals;
    }
}