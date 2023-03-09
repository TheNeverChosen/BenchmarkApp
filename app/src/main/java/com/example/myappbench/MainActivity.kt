package com.example.myappbench

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.myappbench.MeasureMemory.MeasureMemory


class MainActivity : AppCompatActivity() {

    companion object {
        init {
            System.loadLibrary("myappbench")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Python Start

        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(this));
        }

        val py = Python.getInstance()
        val pyobj = py.getModule("PyPidigits")


        val startPy = System.currentTimeMillis()
        val measureMemory = MeasureMemory();
        val threadMemory = Thread(measureMemory)
        threadMemory.start()
        val obj = pyobj.callAttr("pidigits", 10000)
        threadMemory.interrupt()
        val arrayMemory = measureMemory.getArrayMemory()
        val endPy = System.currentTimeMillis()

        for(element in arrayMemory){
            Log.i("elemento python:", element.toString())
        }

        val finalPy = endPy - startPy
        Log.i("Tempo de execucao:", finalPy.toString())
        Log.i("Mensagem de retorno:", obj.toString())

        // Python End

        // Java Start

        val startJv = System.currentTimeMillis()
        val measureMemoryJv = MeasureMemory();
        val threadMemoryJv = Thread(measureMemoryJv)
        threadMemoryJv.start()
        PiBenchGameJava.pidigitsjv(10000)
        val endJv = System.currentTimeMillis()
        threadMemoryJv.interrupt()
        val arrayMemoryJv = measureMemoryJv.getArrayMemory()

        val finalJv = endJv - startJv
        Log.i("Tempo de execucao:", finalJv.toString())

        for(element in arrayMemoryJv){
            Log.i("elemento java:", element.toString())
        }

        // Java End

        // Kotlin Start

        val startKt = System.currentTimeMillis()
        val measureMemoryKt = MeasureMemory();
        val threadMemoryKt = Thread(measureMemoryKt)
        threadMemoryKt.start()
        PiBenchGameKt().run(10000)
        val endKt = System.currentTimeMillis()
        threadMemoryKt.interrupt()
        val arrayMemoryKt = measureMemoryKt.getArrayMemory()

        for(element in arrayMemoryKt){
            Log.i("elemento kotlin:", element.toString())
        }

        val finalKt = endKt - startKt
        Log.i("Tempo de execucao:", finalKt.toString())

        // Kotlin End


        // C Start

        val startC = System.currentTimeMillis()
        val measureMemoryC = MeasureMemory();
        val threadMemoryC = Thread(measureMemoryC)
        threadMemoryC.start()
        cpidigits(10000)
        val endC = System.currentTimeMillis()
        threadMemoryC.interrupt()
        val arrayMemoryC = measureMemoryC.getArrayMemory()
        for(element in arrayMemoryC){
            Log.i("elemento c:", element.toString())
        }

        val finalC = endC - startC
        Log.i("Tempo de execucao:", finalC.toString())

        // C End

        // Cpp Start

        val startCpp = System.currentTimeMillis()
        val measureMemoryCpp = MeasureMemory();
        val threadMemoryCpp = Thread(measureMemoryCpp)
        threadMemoryCpp.start()
        cppidigits(10000)
        val endCpp = System.currentTimeMillis()
        threadMemoryCpp.interrupt()
        val arrayMemoryCpp = measureMemoryCpp.getArrayMemory()
        for(element in arrayMemoryCpp){
            Log.i("elemento cpp:", element.toString())
        }

        val finalCpp = endCpp - startCpp
        Log.i("Tempo de execucao:", finalCpp.toString())

        // Cpp End

        // Rust Start

        val startRs = System.currentTimeMillis()
        val measureMemoryRs = MeasureMemory();
        val threadMemoryRs = Thread(measureMemoryRs)
        threadMemoryRs.start()
        // Função
        val endRs = System.currentTimeMillis()
        threadMemoryRs.interrupt()
        val arrayMemoryRs = measureMemoryRs.getArrayMemory()
        for(element in arrayMemoryRs){
            Log.i("elemento rust:", element.toString())
        }

        val finalRs = endRs - startRs
        Log.i("Tempo de execucao:", finalRs.toString())

        // Rust End

        // Golang Start

        val startGo = System.currentTimeMillis()
        val measureMemoryGo = MeasureMemory();
        val threadMemoryGo = Thread(measureMemoryGo)
        threadMemoryGo.start()
        // Função
        val endGo = System.currentTimeMillis()
        threadMemoryGo.interrupt()
        val arrayMemoryGo = measureMemoryGo.getArrayMemory()
        for(element in arrayMemoryGo){
            Log.i("elemento golang:", element.toString())
        }

        val finalGo = endGo - startGo
        Log.i("Tempo de execucao:", finalGo.toString())

        // Golang End

    }

    external fun cppidigits(num: Int): Int
    external fun cpidigits(num: Int): Int

}