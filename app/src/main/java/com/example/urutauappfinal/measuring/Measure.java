package com.example.urutauappfinal.measuring;

public class Measure{
    protected long time; //time in ms (1ms = 1/1000s)

    public Measure(long time){
        this.time = time;
    }

    //time in ms (1ms = 1/1000s)
    public long getTime(){
        return time;
    }
}
