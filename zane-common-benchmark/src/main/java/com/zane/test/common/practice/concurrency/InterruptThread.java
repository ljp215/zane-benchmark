package com.zane.test.common.practice.concurrency;

/**
 * Author: luojinping
 * Date: 15/11/20
 * Time: 11:05
 */
public class InterruptThread extends Thread {
    private int runTimes;
    private boolean isSleep;

    public InterruptThread(int runTimes, boolean isSleep) {
        this.runTimes = runTimes;
        this.isSleep = isSleep;
    }

    public void run() {
        while (runTimes-- > 0) {
            try {
                if (isSleep) {
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println("Thread-" + Thread.currentThread().getId() + " runTimes:" + runTimes);
            } catch (InterruptedException e) {
                System.out.println("Thread-" + Thread.currentThread().getId() + " interrupted" +
                        "." + e);
                break;
            }
        }
        System.out.println("Thread-" + Thread.currentThread().getId() + " stop");
    }

    public static void main(String[] args) throws InterruptedException {
//        printMsg(true);

        printMsg(false);
    }

    private static void printMsg(boolean isSleep) throws InterruptedException {
        Thread interruptThread = new InterruptThread(100, isSleep);
        interruptThread.start();
        if (isSleep) {
            Thread.sleep(3000);
        }
        interruptThread.interrupt();
        System.out.println("interrupt in main");
    }
}
