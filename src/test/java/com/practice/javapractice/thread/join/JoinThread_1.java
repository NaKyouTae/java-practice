package com.practice.javapractice.thread.join;

public class JoinThread_1 extends Thread{
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3 * 1000);
            }catch (InterruptedException e) {
                System.out.println("Awaken by interrupt()");
            }

            gc();
            System.out.println("Garbage Collected. Free Memory : " + freeMemory());
        }
    }

    public void gc() {
        usedMemory -= 300;
        if(usedMemory < 0) usedMemory = 0;
    }

    public int totalMemory() {return MAX_MEMORY;}
    public int freeMemory() {return MAX_MEMORY - usedMemory;}
}
