package com.zane.test.common.practice.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: luojinping
 * Date: 15/7/14
 * Time: 下午3:19
 */

public class LinkedHashMapTest {

    public static void main(String[] args) {
        testNormalLinkedHashMap();
        System.out.println("==================");
        testAccessOrderLinkedHashMap();
    }

    private static void testNormalLinkedHashMap() {
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("key" + i, "value" + i);
        }
        map.get("key" + 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }

    private static void testAccessOrderLinkedHashMap() {
        Map<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        for (int i = 0; i < 5; i++) {
            map.put("key" + i, "value" + i);
        }
        map.get("key" + 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}

