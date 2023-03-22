package com.example.myappbench

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myappbench.benchmarking.Benchmark
import java.util.Objects


class MainActivity : AppCompatActivity() {

    companion object {
        init {
            System.loadLibrary("myappbench")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bench = Benchmark(this)

        //PiDigits
        val piArgs = Array<Any>(1){10000}
        val piDigitsResJava = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.PI_DIGITS, piArgs)
        val piDigitsResKotlin = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.PI_DIGITS, piArgs)

        Log.i("BENCHMARK JAVA", piDigitsResJava.toString());
        Log.i("BENCHMARK KOTLIN", piDigitsResKotlin.toString());

//        // Python Start
//
//        if (! Python.isStarted()) {
//            Python.start(AndroidPlatform(this))
//        }
//
//        val py = Python.getInstance()
//        val pyobj = py.getModule("PyPidigits")
//        val startPy = System.currentTimeMillis()
//        pyobj.callAttr("pidigits", 10000)
//        val endPy = System.currentTimeMillis()
//        val finalPy = endPy - startPy
//        Log.i("Tempo de execucao Python Pidigits:", finalPy.toString())
//
//        // Python End
//
//        // Java Start
//
//        val startJv = System.currentTimeMillis()
//        PiBenchGameJava.pidigitsjv(10000)
//        val endJv = System.currentTimeMillis()
//        val finalJv = endJv - startJv
//        Log.i("Tempo de execucao Java fannkuch:", finalJv.toString())
//
//        //TreeBenchGameJava.run(21)
//        //FannkuchBenchGameJava.run(12)
//        //BodyBenchGameJava.run(50000000)
//
//        // Java End
//
//        // Kotlin Start
//
//        val startKt = System.currentTimeMillis()
//        PiBenchGameKt().run(10000)
//        val endKt = System.currentTimeMillis()
//        val finalKt = endKt - startKt
//        Log.i("Tempo de execucao Kotlin pidigits:", finalKt.toString())
//
//        //TreeBenchGameKt().run(21)
//        //FannkuchBenchGameKt().run(12)
//        //BodyBenchGameKt.run(50000000)
//
//        // Kotlin End

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