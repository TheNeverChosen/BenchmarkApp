package com.example.app;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import com.chaquo.python.*;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.chaquo.python.android.AndroidPlatform;
import com.example.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'app' library on application startup.
    static {
        System.loadLibrary("app");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        // Função Java

        long startJv = System.currentTimeMillis();
        PiBenchGameJava.run(10000);
        long endJv = System.currentTimeMillis();

        long finalJv = endJv - startJv;

        // Função Kotlin

        long startKt = System.currentTimeMillis();
        PiBenchGameKtKt.run(10000);
        long endKt = System.currentTimeMillis();

        long finalKt = endKt - startKt;

        // Função Golang

        long startGo = System.currentTimeMillis();
        // Função
        long endGo = System.currentTimeMillis();

        long finalGo = endGo - startGo;

        // Função Python

        Python py = Python.getInstance();
        PyObject obj = py.getModule("PyDigitis");

        long startPy = System.currentTimeMillis();
        PyObject result = obj.callAttr("pidigits", 10000);
        long endPy = System.currentTimeMillis();

        long finalPy = endPy - startPy;

        // Função Rust

        long startRs = System.currentTimeMillis();
        // Função
        long endRs = System.currentTimeMillis();

        long finalRs = endRs - startRs;

        // Função CPP

        long startCpp = System.currentTimeMillis();
        int valor = cppidigits(10000);
        long endCpp = System.currentTimeMillis();

        long finalCpp = endCpp - startCpp;

        // Função C

        long startC = System.currentTimeMillis();
        int valor2 = cpidigits(10000);
        long endC = System.currentTimeMillis();

        long finalC = endC - startC;

    }

    /**
     * A native method that is implemented by the 'app' native library,
     * which is packaged with this application.
     */

    public native int cppidigits(int num);
    public native int cpidigits(int num);
}