package com.example.urutauappfinal

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.urutauappfinal.benchmarking.Benchmark
import com.example.urutauappfinal.collectionFiles.EscritorDeArquivo
import com.example.urutauappfinal.databinding.ActivityMainBinding
import com.example.urutauappfinal.measuring.MeasureFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var timesleep = 180000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bench = Benchmark(this)

        //Pidigits
//        val piArgs = Array<Any>(1){10000}
//
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.PI_DIGITS, piArgs)
//            Log.i("C Alg Pidigits: ",data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.PI_DIGITS,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.PI_DIGITS, piArgs)
//            Log.i("CPP Alg Pidigits: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.PI_DIGITS,data);
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.PI_DIGITS, piArgs)
//            Log.i("Java Alg Pidigits: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.PI_DIGITS,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..2){
//            var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.PI_DIGITS, piArgs)
//            Log.i("Kotlin Alg Pidigits: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.PI_DIGITS,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.PI_DIGITS, piArgs)
//            Log.i("Python Alg Pidigits: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.PI_DIGITS,data)
//        }
//        Thread.sleep(timesleep)
//         //NBody
//
//        val nBodyArgs = Array<Any>(1){50000000}
//
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.NBODY, nBodyArgs)
//            Log.i("C Alg NBody: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.NBODY,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.NBODY, nBodyArgs)
//            Log.i("CPP Alg NBody: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.NBODY,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.NBODY, nBodyArgs)
//            Log.i("Java Alg NBody: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.NBODY,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.NBODY, nBodyArgs)
//            Log.i("Kotlin Alg NBody: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.NBODY,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..3){
//            val data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.NBODY, nBodyArgs)
//            Log.i("Python Alg NBody: ", data.toString())
//            Log.i("tam",data.memEnLs.size.toString());
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.NBODY,data)
//        }
//        Thread.sleep(timesleep)
//
//        // Fasta
//
//        val fastaArgs = Array<Any>(1){25000000}
//
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.FASTA, fastaArgs)
//            Log.i("C Alg Fasta: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.FASTA,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.FASTA, fastaArgs)
//            Log.i("CPP Alg Fasta: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.FASTA,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.FASTA, fastaArgs)
//            Log.i("Java Alg Fasta: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.FASTA,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.FASTA, fastaArgs)
//            Log.i("Kotlin Alg Fasta: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.FASTA,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..4){
//            var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.FASTA, fastaArgs)
//            Log.i("Python Alg Fasta: ", data.toString())
//            Log.i("tam",data.memEnLs.size.toString());
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.FASTA,data)
//        }
//        Thread.sleep(timesleep)
//        // FannKuch
//
//
        val fannkuchArgs = Array<Any>(1){12}

//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//            Log.i("C Alg Fannkuch: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.FANNKUCH,data)
//        }
//        Thread.sleep(timesleep)

        for(i in 1..11){
            var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
            Log.i("CPP Alg Fannkuch: ", data.toString())
            EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.FANNKUCH,data)
        }
//        //Thread.sleep(timesleep)
//
//
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//            Log.i("Java Alg Fannkuch: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.FANNKUCH,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//            Log.i("Kotlin Alg Fannkuch: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.FANNKUCH,data)
//        }
//        Thread.sleep(timesleep)
//
//        // BinaryTrees
//
//        val binaryArgs = Array<Any>(1) { 21}
//
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//            Log.i("C Alg BinaryTree: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.BINARY_TREES,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//            Log.i("CPP Alg BinaryTree: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.BINARY_TREES,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//            Log.i("Python Alg BinaryTree: ", data.toString())
//            Log.i("tam",data.memEnLs.size.toString());
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.BINARY_TREES,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//            Log.i("Java Alg BinaryTree: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.BINARY_TREES,data)
//        }
//        Thread.sleep(timesleep)
//        for(i in 1..3){
//            var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//            Log.i("Kotlin Alg BinaryTree: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.BINARY_TREES,data)
//        }
//        Thread.sleep(timesleep)
//
//        for(i in 1..11){
//            var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//            Log.i("Python Alg Fannkuch: ", data.toString())
//            EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.FANNKUCH,data)
//        }
    }

}