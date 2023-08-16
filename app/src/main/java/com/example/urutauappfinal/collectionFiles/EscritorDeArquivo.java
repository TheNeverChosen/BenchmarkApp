package com.example.urutauappfinal.collectionFiles;

import android.os.Environment;
import android.util.Log;

import com.example.urutauappfinal.benchmarking.Benchmark;
import com.example.urutauappfinal.benchmarking.BenchmarkData;
import com.example.urutauappfinal.measuring.GeneralMeasure;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedList;

public class EscritorDeArquivo {
    static FileWriter escritor = null;
    public static boolean criarEscrever(Benchmark.Language language,Benchmark.Algorithm bench, BenchmarkData data) {
        try {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                String diretorio = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/coleta/";
                File pasta = new File(diretorio);
                if (!pasta.exists()) pasta.mkdir();
                String nomeArquivo;
                File arquivo = null;
                int contador=1;
                do{
                    nomeArquivo = language.name()+"-"+bench.name()+"-"+contador+".csv";
                    arquivo = new File(pasta,nomeArquivo);
                    contador++;
                }while(arquivo.exists());
                arquivo.createNewFile();
                escritor = new FileWriter(arquivo);
                escritor.append(language.name()+"-"+bench.name()+"\n");
                escreverDados(data,language);
                escritor.flush();
                escritor.close();
                Log.i("escrita","escrita terminada!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Log.i("finish","escrita não terminada2!");
            return false;
        }
        return true;
    }

    private static boolean escreverDados(BenchmarkData data, Benchmark.Language language) {
        try {
            LinkedList<GeneralMeasure> memEnLs = (LinkedList<GeneralMeasure>) data.getMemEnLs().clone();
            escritor.append("tempo,memoryOthers,memoryHeapJava,memoryNative,memoryCode,memoryStack,current,voltage\n");
            for(GeneralMeasure ls: memEnLs){
               escritor.append(ls.getTime() +","+ls.getMemoryOthers()+","+ls.getMemoryHeapJava()+","+ls.getMemoryNative()+","+ls.getMemoryCode()
                        +","+ls.getMemoryStack()+","+ls.getCurrent()+","+ls.getVoltage()+"\n");
            }
            escritor.append("fim");
        }
        catch (Exception e){
            e.printStackTrace();
            Log.i("finish","escrita não terminada4!");
            return false;
        }
        return true;
    }

}
