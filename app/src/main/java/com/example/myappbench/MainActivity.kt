package com.example.myappbench

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.myappbench.FannkuchBenchGameJava.main
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

        /*if (! Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        val py = Python.getInstance()
        val pyobj = py.getModule("PyBinaryTrees")
        val startPy = System.currentTimeMillis()
        pyobj.callAttr("binary_trees", 21)
        val endPy = System.currentTimeMillis()
        val finalPy = endPy - startPy
        Log.i("Tempo de execucao Python Binary Trees:", finalPy.toString())

        // Python End*/

        // Java Start

        val startJv = System.currentTimeMillis()
        FannkuchBenchGameJava.main(12)
        //TreeBenchGameJava.run(21)
        //PiBenchGameJava.pidigitsjv(10000)
        //BodyBenchGameJava.run(50000000)
        val endJv = System.currentTimeMillis()
        val finalJv = endJv - startJv
        Log.i("Java Fannkuch:", finalJv.toString())

        // Java End

        // Kotlin Start

        val startKt = System.currentTimeMillis()
        //PiBenchGameKt().run(10000)
        //TreeBenchGameKt().run(21)
        FannkuchBenchGameKt().main(12)
        //BodyBenchGameKt().run(50000000)
        val endKt = System.currentTimeMillis()
        val finalKt = endKt - startKt
        Log.i("Kotlin fannkuch:", finalKt.toString())

        // Kotlin End

        // C Start

        val startC = System.currentTimeMillis()
        cFannkuch(12)
        // cNbody(50000000)
        // cBinaryTrees(21)
        // cpidigits(10000);
        val endC = System.currentTimeMillis()
        val finalC = endC - startC
        Log.i("C fannkuch:", finalC.toString())

        // C End

        // C++ Start

        val startCpp = System.currentTimeMillis();
        cppFannkuch(12);
        // cppNbody(50000000);
        // cppidigits(10000);
        // cppBinaryTrees(21);
        val endCpp = System.currentTimeMillis();
        val finalCpp = endCpp - startCpp;
        Log.i("Cpp Fannkuch: ", finalCpp.toString());

        // C++ End

    }

    external fun cppidigits(num: Int)
    external fun cpidigits(num: Int)

    external fun cppFannkuch(num: Int)
    external fun cFannkuch(num: Int)

    external fun cppBinaryTrees(num: Int)
    external fun cBinaryTrees(num: Int)

    external fun cppNbody(num: Int)
    external fun cNbody(num: Int)

}