package com.zane.test.common.practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: luojinping
 * Date: 15/11/20
 * Time: 11:06
 */
public class ExecutorServiceTest {
    private int threadNum = 3;
    private ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

    public void testShutdown() {
        for (int i = 0; i < threadNum; i++) {
            executorService.submit(new InterruptThread(i, true));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(1000);
                System.out.println("waiting for executorService tasks finished");
            } catch (InterruptedException ignored) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorServiceTest executorServiceTest = new ExecutorServiceTest();
        executorServiceTest.testShutdown();
    }
}
