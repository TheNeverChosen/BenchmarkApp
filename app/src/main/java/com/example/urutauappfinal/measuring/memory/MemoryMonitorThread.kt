package com.example.urutauappfinal.measuring.memory

import android.util.Log
import com.example.urutauappfinal.measuring.MeasureFactory
import java.util.LinkedList

class MemoryMonitorThread : Thread(){
    private val memoryVals = LinkedList<MemoryMeasure>()
    private var mRunning = false

    override fun run() {
        mRunning = true
        while(mRunning) {
            memoryVals.add(MeasureFactory.getMemory())
            try{
                sleep(MeasureFactory.MEASUREMENT_INTERVAL_MS);
            }
            catch (e: InterruptedException){
                e.printStackTrace()
            }
        }
    }

    fun stopMonitoring() {
        mRunning = false
    }

    fun getMemoryVals(): LinkedList<MemoryMeasure> {
        return memoryVals;
    }
}