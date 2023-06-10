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
    static long MB = 1024*1024;
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
                escreverDados(data);
                escritor.flush();
                escritor.close();

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void escreverDados(BenchmarkData data) {
        try {
            LinkedList<MemoryMeasure> memLs = data.getMemLs();
            LinkedList<EnergyMeasure> energyLs = data.getEnergyLs();
            long mediaTotalMemory=0,mediaFreeMemory=0,mediaUsedMemory=0;
            escritor.append("tempo em (ms),TotalMemory (MB),FreeMemory (MB),UsedMemory (MB)\n");
            for (MemoryMeasure mem : memLs) {
                escritor.append(mem.getTime() + "," + mem.getTotalMemory() / MB + "," + mem.getFreeMemory() / MB + ","+(mem.getTotalMemory()-mem.getFreeMemory())/MB+"\n");
                mediaTotalMemory+=mem.getTotalMemory();
                mediaFreeMemory+=mem.getFreeMemory();
            }
            mediaUsedMemory = (mediaTotalMemory-mediaFreeMemory)/memLs.size();
            mediaTotalMemory/=memLs.size();
            mediaFreeMemory/=memLs.size();
            escritor.append("média,"+mediaTotalMemory/MB+","+mediaFreeMemory/MB+","+mediaUsedMemory/MB+"\n");
            escritor.append("tempo em (ms),Voltagem (V),Corrente (A),Potência (W)\n");
            for (EnergyMeasure energy : energyLs) {
                escritor.append(energy.getTime() + "," + energy.getVoltageVolt() + "," + energy.getCurrentAmpere() + ","+energy.getPowerWatt()+"\n");
            }
            escritor.append("Tempo inicial (ms),Tempo final (ms),Duração (ms),Energia total (J)\n");
            escritor.append(data.getTimeStart()+","+data.getTimeEnd()+", "+data.getDuration()+","+data.getTotalEnergyJoules()+"\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
