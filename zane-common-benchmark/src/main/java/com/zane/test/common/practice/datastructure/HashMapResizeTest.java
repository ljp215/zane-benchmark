package com.zane.test.common.practice.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: luojinping
 * Date: 15/8/21
 * Time: 下午6:07
 */
public class HashMapResizeTest {
    private static int initialCapacity = 8;
    private static float loadFactor = (float) 0.5;
    private static final Runtime s_runtime = Runtime.getRuntime();


    public static void main(String[] args) throws Exception {
        Map<String, String> hashMap = new HashMap<>(initialCapacity, loadFactor);

        long startHeap = usedMemory();

        int from = 0, end = 50;
        insert(hashMap, from, end);
        printHeapDetail("insert 0-50", startHeap);

        from = 50;
        end = 100;
        insert(hashMap, from, end);
        printHeapDetail("insert 50-100", startHeap);

        from = 100;
        end = 1000;
        insert(hashMap, from, end);
        printHeapDetail("insert 100-1000", startHeap);

        from = 100;
        end = 1000;
        remove(hashMap, from, end);
        printHeapDetail("remove 100-1000", startHeap);

        hashMap.clear();
        printHeapDetail("clear all", startHeap);

        printHeapDetail("gc", startHeap);
    }

    private static void insert(Map<String, String> hashMap, int from, int end) {
        for (int i = from; i < end; i++) {
            hashMap.put("key" + i, "value" + i);
        }
    }

    private static void remove(Map<String, String> hashMap, int from, int end) {
        for (int i = from; i < end; i++) {
            hashMap.remove("key" + i);
        }
    }

    private static void printHeapDetail(String info, long beforeHeap) throws Exception {
        long afterHeap = usedMemory();
        System.out.println(info);
        System.out.println("before heap: " + beforeHeap + ", after heap: " + afterHeap);
        System.out.println("heap delta: " + (afterHeap - beforeHeap));
        System.out.println("================");
    }

    private static long usedMemory() {
        return s_runtime.totalMemory() - s_runtime.freeMemory();
    }
}
