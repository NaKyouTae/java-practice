package com.practice.javapractice.thread;

import javax.swing.*;

public class MainThread {
    public static void main(String[] args) {
        MyThread_1 t1 = new MyThread_1();

//        Runnable r = new MyThread_2();
//        Thread t2 = new Thread(r);

        // start는 새로운 쓰레드 생성 후 호출스택 생성
        // run은 main 쓰레드에 호출스택 추가
        t1.start();

        String input = JOptionPane.showInputDialog("입력하세여");
        System.out.println("입력 된 값 : " + input);
        System.out.println(t1.getState());
        t1.interrupt();
        System.out.println(t1.getState());
        System.out.println("isInterrupted : " + t1.isInterrupted()) ;
    }
}
