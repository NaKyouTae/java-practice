package com.practice.javapractice.thread.join;

import java.util.Random;

public class JoinThread {
    public static void main(String[] args) {
        JoinThread_1 gc = new JoinThread_1();
        gc.setDaemon(true);
        gc.start();

        int requiredMemory = 0;

        for(int i = 0; i < 20; i++) {
            requiredMemory = (int) (Math.random() * 10) * 20;

            if(gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
                gc.interrupt();
                try{
                    gc.join(100);
                }catch(InterruptedException e) {}
            }

            gc.usedMemory += requiredMemory;
            System.out.println("usedMemory : " + gc.usedMemory);
        }

    }
}
