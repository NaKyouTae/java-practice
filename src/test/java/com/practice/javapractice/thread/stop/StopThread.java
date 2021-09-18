package com.practice.javapractice.thread.stop;

public class StopThread {
    public static void main(String[] args) {
        StopThread_1 t1 = new StopThread_1("*");
        StopThread_1 t2 = new StopThread_1("**");
        StopThread_1 t3 = new StopThread_1("***");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
            t1.suspend();
            Thread.sleep(2000);
            t2.suspend();
            Thread.sleep(3000);
            t1.resume();
            Thread.sleep(3000);
            t1.stop();
            t2.stop();
            Thread.sleep(2000);
            t3.stop();
        }catch (InterruptedException e) {}
    }
}
