package com.example.urutauappfinal.collectionFiles;

import android.os.Environment;

import com.example.urutauappfinal.benchmarking.Benchmark;
import com.example.urutauappfinal.benchmarking.BenchmarkData;
import com.example.urutauappfinal.measuring.energy.EnergyMeasure;
import com.example.urutauappfinal.measuring.memory.MemoryMeasure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;

public class EscritorDeArquivo {
    static double MB = 1024*1024;
    static FileWriter escritor = null;
    public static void criarEscrever(Benchmark.Language language,Benchmark.Algorithm bench, BenchmarkData data) {
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

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void escreverDados(BenchmarkData data,Benchmark.Language language) {
        try {
            LinkedList<MemoryMeasure> memLs = data.getMemLs();
            LinkedList<EnergyMeasure> energyLs = data.getEnergyLs();
            double mediaUsedMemory=0,usedMemory=0;
            escritor.append("tempo,memória utilizada (MB)\n");
            for (MemoryMeasure mem : memLs) {
                if(language==Benchmark.Language.C || language==Benchmark.Language.CPP) usedMemory = mem.getMemoryNative();
                else if(language==Benchmark.Language.PYTHON) usedMemory = mem.getMemoryNative()+mem.getMemoryOthers();
                else usedMemory = mem.getTotalMemory()-mem.getFreeMemory();
                usedMemory/=MB;
                escritor.append(mem.getTime() +","+usedMemory+"\n");
                mediaUsedMemory+=usedMemory;
            }
            mediaUsedMemory /= memLs.size();
            escritor.append("tempo,Voltagem (V),Corrente (A),Potência (W)\n");
            for (EnergyMeasure energy : energyLs) {
                escritor.append(energy.getTime() + "," + energy.getVoltageVolt() + "," + energy.getCurrentAmpere() + ","+energy.getPowerWatt()+"\n");
            }
            escritor.append("Duração (ms),Média de memória,Energia total (J)\n");
            escritor.append((data.getDuration()/1000)+","+(mediaUsedMemory)+","+data.getTotalEnergyJoules()+"\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
