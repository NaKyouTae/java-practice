package com.practice.javapractice.thread;

public class MyThread_2 implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }

        System.out.println("Thread Two");
    }
}
