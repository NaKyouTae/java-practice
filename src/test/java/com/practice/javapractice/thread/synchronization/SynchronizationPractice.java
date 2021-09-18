package com.practice.javapractice.thread.synchronization;

public class SynchronizationPractice {
    public static void main(String[] args) {
        Runnable r = new SynchronizationThread();
        new Thread(r).start();
        new Thread(r).start();
    }
}
