package com.example.urutauappfinal.measuring.memory

import android.os.Build
import android.os.Debug
import android.os.Debug.MemoryInfo
import androidx.annotation.RequiresApi
import com.example.urutauappfinal.measuring.MeasureFactory
import java.util.LinkedList

class MemoryMonitorThread : Thread(){
    private val memoryVals = LinkedList<MemoryMeasure>()
    private var mRunning = false
    override fun run() {

        mRunning = true
        while(mRunning) {
            try{
                sleep(MeasureFactory.MEASUREMENT_INTERVAL_MS);
            }
            catch (e: InterruptedException){
                e.printStackTrace()
            }
            memoryVals.add(MeasureFactory.getMemory())
        }
    }

    fun stopMonitoring() {
        mRunning = false
    }

    fun getMemoryVals(): LinkedList<MemoryMeasure> {
        return memoryVals;
    }
}