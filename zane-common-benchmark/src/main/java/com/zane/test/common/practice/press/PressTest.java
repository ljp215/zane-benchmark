package com.zane.test.common.practice.press;

/**
 * Author: luojinping
 * Date: 15/12/7
 * Time: 18:46
 * 代码可读性和运行效率的平衡
 */
public class PressTest {


    public static void main(String[] args) {
        int testTimes = 1000000;

        IncreByType increByType = new IncreByType();
        testReadale(increByType, testTimes);

        IncreByType increByType2 = new IncreByType("a");
        testEfficient(increByType2, testTimes);
    }

    private static void testReadale(IncreByType increByType, int testTimes) {
        long startTime = System.currentTimeMillis();

        int x = 0;
        for (int i = 0; i < testTimes; i++) {
            for (int j = 0; j < testTimes; j++) {
                x = increByType.funReadable("a", x);
                if (x == Integer.MAX_VALUE) {
                    x = 0;
                    System.out.println("reset x to 0");
                }
            }
        }
        System.out.println("testReadale x: " + x);

        System.out.println("readable codes cost: " + (System.currentTimeMillis() - startTime));
    }

    private static void testEfficient(IncreByType increByType, int testTimes) {
        long startTime = System.currentTimeMillis();

        int x = 0;
        for (int i = 0; i < testTimes; i++) {
            for (int j = 0; j < testTimes; j++) {
                x = increByType.funEfficient(x);
                if (x == Integer.MAX_VALUE) {
                    x = 0;
                    System.out.println("reset x to 0");
                }
            }
        }
        System.out.println("testEfficient x: " + x);

        System.out.println("testEfficient codes cost: " + (System.currentTimeMillis() - startTime));
    }


    public static class IncreByType {
        private int increVal = 0;

        private String typeVal = "";

        public IncreByType() {

        }

        public IncreByType(String typeVal) {
            this.typeVal = typeVal;
            if ("a".equals(typeVal)) {
                increVal = 1;
            } else if ("b".equals(typeVal)) {
                increVal = 2;
            }
        }

        private int funReadable(String type, int x) {
            int incre = 0;
            if ("a".equals(type)) {
                incre = 1;
            } else if ("b".equals(type)) {
                incre = 2;
            }
            return x + incre;
        }

        private int funEfficient(int x) {
            return x + increVal;
        }
    }
}
