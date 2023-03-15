package com.example.myappbench

class MeasureMemory {
    class MeasureMemory: Runnable{
        private val mb = 1024*1024;
        private val arrayMemory = ArrayList<Long>();

        override fun run() {
            val initialUsedMemory = (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/mb;
            while(true) {
                try {
                    Thread.sleep(1000)
                }
                catch (e: InterruptedException){
                    e.printStackTrace()
                }
                var usedMemoryCurrent = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
                    .freeMemory()) / mb - initialUsedMemory;
                arrayMemory.add(usedMemoryCurrent);
            }
        }

        public fun getArrayMemory(): ArrayList<Long>{
            return arrayMemory;
        }

    }
}