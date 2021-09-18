package com.practice.javapractice.thread.stop;

public class StopThread_1  implements Runnable{
    Thread tr;

    volatile boolean suspend = false;
    volatile boolean stop = false;

    StopThread_1(String name) {
        tr = new Thread(this, name);
    }

    @Override
    public void run() {
        String name = tr.getName();
        while(!stop) {
            if(!suspend) {
                System.out.println(name);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    System.out.println(name + " - interrupted");
                }
            }else {
                Thread.yield();
            }
        }
        System.out.println(name + "- stopped");;
    }

    public void suspend() {
        suspend = true;
        tr.interrupt();
        System.out.println(tr.getName() + " - interrupt() by suspend()");
    }
    public void resume() {suspend = false;}
    public void stop() {
        stop = true;
        tr.interrupt();
        System.out.println(tr.getName() + " - interrupt() by stop()");
    }
    public void start() {tr.start();}
}
