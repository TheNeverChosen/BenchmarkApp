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


class MainActivity : AppCompatActivity() {
    var REQUEST_CODE = 1
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //checkPermission()
        val bench = Benchmark(this)

        // Pidigits
        val piArgs = Array<Any>(1){10000}

//        var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.PI_DIGITS, piArgs)
//        Log.i("C Alg Pidigits: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.PI_DIGITS,data)

//        var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.PI_DIGITS, piArgs)
//        Log.i("CPP Alg Pidigits: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.PI_DIGITS,data)

//        var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.PI_DIGITS, piArgs)
//        Log.i("Java Alg Pidigits: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.PI_DIGITS,data)

//        var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.PI_DIGITS, piArgs)
//        Log.i("Kotlin Alg Pidigits: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.PI_DIGITS,data)

//        var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.PI_DIGITS, piArgs)
//        Log.i("Python Alg Pidigits: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.PI_DIGITS,data)


        // NBody

        val nBodyArgs = Array<Any>(1){50000000}

//        var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.NBODY, nBodyArgs)
//        Log.i("C Alg NBody: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.NBODY,data)

//        var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.NBODY, nBodyArgs)
//        Log.i("CPP Alg NBody: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.NBODY,data)

//        var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.NBODY, nBodyArgs)
//        Log.i("Java Alg NBody: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.NBODY,data)

//        var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.NBODY, nBodyArgs)
//        Log.i("Kotlin Alg NBody: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.NBODY,data)

//        var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.NBODY, nBodyArgs)
//        Log.i("Python Alg NBody: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.NBODY,data)

        // Fasta

        val fastaArgs = Array<Any>(1){25000000}

//        var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.FASTA, fastaArgs)
//        Log.i("C Alg Fasta: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.FASTA,data)

//        var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.FASTA, fastaArgs)
//        Log.i("CPP Alg Fasta: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.FASTA,data)

//        var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.FASTA, fastaArgs)
//        Log.i("Java Alg Fasta: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.FASTA,data)

//        var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.FASTA, fastaArgs)
//        Log.i("Kotlin Alg Fasta: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.FASTA,data)

        var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.FASTA, fastaArgs)
        Log.i("Python Alg Fasta: ", data.toString())
        EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.FASTA,data)


        // FannKuch

        val fannkuchArgs = Array<Any>(1){12}

//        var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//        Log.i("C Alg Fannkuch: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.FANNKUCH,data)

//        var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//        Log.i("CPP Alg Fannkuch: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.FANNKUCH,data)

//        var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//        Log.i("Java Alg Fannkuch: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.FANNKUCH,data)

//        var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//        Log.i("Kotlin Alg Fannkuch: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.FANNKUCH,data)

//        var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.FANNKUCH, fannkuchArgs)
//        Log.i("Python Alg Fannkuch: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.FANNKUCH,data)

        // BinaryTrees

        val binaryArgs = Array<Any>(1) { 21}

//        var data = bench.execute(Benchmark.Language.C, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//        Log.i("C Alg BinaryTree: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.C,Benchmark.Algorithm.BINARY_TREES,data)

//        var data = bench.execute(Benchmark.Language.CPP, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//        Log.i("CPP Alg BinaryTree: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.CPP,Benchmark.Algorithm.BINARY_TREES,data)

//        var data = bench.execute(Benchmark.Language.JAVA, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//        Log.i("Java Alg BinaryTree: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.JAVA,Benchmark.Algorithm.BINARY_TREES,data)

//        var data = bench.execute(Benchmark.Language.KOTLIN, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//        Log.i("Kotlin Alg BinaryTree: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.KOTLIN,Benchmark.Algorithm.BINARY_TREES,data)

//        var data = bench.execute(Benchmark.Language.PYTHON, Benchmark.Algorithm.BINARY_TREES, binaryArgs)
//        Log.i("Python Alg BinaryTree: ", data.toString())
//        EscritorDeArquivo.criarEscrever(Benchmark.Language.PYTHON,Benchmark.Algorithm.BINARY_TREES,data)


        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
    }

    /**
     * A native method that is implemented by the 'urutauappfinal' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'urutauappfinal' library on application startup.
        init {
            System.loadLibrary("urutauappfinal")
        }
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // A permissão já foi concedida, pode prosseguir com as ações necessárias.
        } else {
            // A permissão não foi concedida, solicite-a em tempo de execução.
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão concedida, pode prosseguir com as ações necessárias.
            } else {
                // Permissão negada, tome as medidas apropriadas ou solicite novamente.
            }
        }
    }
}