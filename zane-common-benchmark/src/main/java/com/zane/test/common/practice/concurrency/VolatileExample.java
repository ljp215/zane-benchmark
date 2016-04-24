package com.zane.test.common.practice.concurrency;

/**
 * Author: luojinping
 * Date: 15/5/28
 * Time: 下午11:00
 */
public class VolatileExample {
    static long startTime;
    volatile int x = 0;
    volatile int b = 0;
    private static double getTime() {
        return (System.currentTimeMillis() - startTime) / 1000.0;
    }

    private void write() {
        System.out.println("write1: b = " + b + ", x = " + x + ", thread = " + Thread
                .currentThread().getName() + ", time = " + getTime());
        x = 3;
        b = 1;
        System.out.println("write2: b = " + b + ", x = " + x + ", thread = " + Thread
                .currentThread().getName() + ", time = " + getTime());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x = 5;
        System.out.println("write3: b = " + b + ", x = " + x + ", thread = " + Thread
                .currentThread().getName() + ", time = " + getTime());
    }

    private void read() {
        System.out.println("read1: b = " + b + ", x = " + x + ", thread = " + Thread
                .currentThread().getName() + ", time = " + getTime());
        while (x != 5) {
        }
        System.out.println("read2: b = " + b + ", x = " + x + ", thread = " + Thread
                .currentThread().getName() + ", time = " + getTime());
    }

    public static void main(String[] args) throws Exception {
        final VolatileExample example = new VolatileExample();
        Thread write = new Thread(new Runnable() {
            public void run() {
                example.write();
            }
        });
        write.setName("write");

        Thread readA = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });
        readA.setName("readA");

        Thread readB = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });
        readB.setName("readB");

        VolatileExample.startTime = System.currentTimeMillis();

        write.start();
        Thread.sleep(1000);
        readA.start();

        Thread.sleep(2000);
        readB.start();

        write.join();
        System.out.println("main: b = " + example.b + ", x = " + example.x + ", threadId = " +
                Thread.currentThread().getId());
        readA.join();
        readB.join();
    }
}
