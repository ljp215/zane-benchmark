package com.zane.test.common.practice.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: luojinping
 * Date: 15/11/20
 * Time: 11:06
 */
public class InstructionReorder {
    private static int a = 0, b = 0, x = 0, y = 0;

    private static CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000000; i++) {
            Thread one = new Thread(new Runnable() {
                public void run() {
                    try {
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    try {
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    b = 1;
                    y = a;
                }
            });

            one.start();
            other.start();
            one.join();
            other.join();

            System.out.println("run " + i + " times (" + x + "," + y + ")");

            if ((x == 0) && (y == 0)) {
                break;
            } else {
                a = 0;
                b = 0;
                x = 0;
                y = 0;
            }
        }
        System.out.println("end");
    }
}
