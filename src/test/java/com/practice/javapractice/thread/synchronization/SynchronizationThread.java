package com.practice.javapractice.thread.synchronization;

public class SynchronizationThread implements Runnable {
    SynchronizationAccount ac = new SynchronizationAccount();

    @Override
    public void run() {
        while(ac.getBlance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            ac.withdraw(money);
            System.out.println(Thread.currentThread().getName() + " blance : " + ac.getBlance());
        }
    }
}