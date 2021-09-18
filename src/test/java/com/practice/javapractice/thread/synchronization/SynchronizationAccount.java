package com.practice.javapractice.thread.synchronization;

public class SynchronizationAccount {
    private int blance = 1000;

    public int getBlance() {
        return this.blance;
    }

    public synchronized void withdraw(int money){
        System.out.println("money : " + money);
        if(blance >= money) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}

            blance -= money;
        }
    }

}
