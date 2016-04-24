package com.zane.test.common.practice;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: luojinping
 * Date: 15/6/6
 * Time: 上午9:39
 */
public class X {
    public static final int PRINT_INTERVAL = 10000;

    public static void main(String[] args) throws Exception {
        memoryNoLeak();
    }


    private static void memoryLeak() throws InterruptedException {
        int times = 0;

        List<Object> list = new ArrayList<>();

        Object initObj = new Object();
        list.add(initObj);

        while (true) {
            for (int i = 0; i < 100; i++) {
                Object obj = new Object();
                list.add(obj);
                obj = null;
            }

            if (times % PRINT_INTERVAL == 0) {
                Thread.sleep(1000);
                printMemoryUsage();
                System.out.println("loop times: " + times);
            }

            times++;
        }
    }

    private static void memoryNoLeak() throws InterruptedException {
        int times = 0;

        List<Object> list = new ArrayList<>();

        Object initObj = new Object();
        list.add(initObj);

        while (true) {
            for (int i = 0; i < 100; i++) {
                Object obj = new Object();
                list.add(initObj);
                obj = null;
            }

            if (times % PRINT_INTERVAL == 0) {
                Thread.sleep(1000);
                printMemoryUsage();
                System.out.println("loop times: " + times);
            }

            times++;
        }
    }

    private static void printMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();

        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        sb.append("free memory: ").append(format.format(freeMemory / 1024)).append("\n");
        sb.append("allocated memory: ").append(format.format(allocatedMemory / 1024)).append("\n");
        sb.append("max memory: ").append(format.format(maxMemory / 1024)).append("\n");
        sb.append("total free memory: ").append(format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024)).append("\n");

        System.out.println(sb.toString());
    }

}
