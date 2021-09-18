package com.practice.javapractice.thread;

public class MyThread_1 extends Thread {
    public void run() {

        int i = 10;

        while(i != 0 && !isInterrupted()) {
            System.out.println(i--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException r) {}
        }
//        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
