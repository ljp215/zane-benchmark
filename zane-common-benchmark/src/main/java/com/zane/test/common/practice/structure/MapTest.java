package com.zane.test.common.practice.structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Author: luojinping
 * Date: 15/1/16
 * Time: 上午8:49
 */
public class MapTest {
    private static class Instance {
        String name;
        int age;

        private Instance(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Instance instance = (Instance) o;

            if (age != instance.age) return false;
            if (name != null ? !name.equals(instance.name) : instance.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }

        @Override
        public String toString() {
            return "Instance{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Instance instance1 = new Instance("a", 20);
        Instance instance2 = new Instance("b", 21);
        Instance instance3 = new Instance("c", 21);
        Instance instance4 = new Instance("d", 23);

        Map<Instance, Integer> InsMap = new HashMap<>();
        InsMap.put(instance1, 1);
        InsMap.put(instance2, 2);
        InsMap.put(instance3, 3);


        Set<Instance> keySet = InsMap.keySet();
        keySet.remove(instance1);
        try {
            keySet.add(instance4);
        } catch (Exception e) {
            System.err.println("keySet add Exception, e:" + e);
        }

        for (Instance key : InsMap.keySet()) {
            keySet.remove(instance2);
            System.out.println(InsMap.get(key));
        }

        boolean isTest = true;
        Iterator<Map.Entry<Instance, Integer>> it = InsMap.entrySet().iterator();
        while (it.hasNext()) {
            if (isTest) {
                try {
                    it.remove();
                } catch (Exception e) {
                    System.err.println("iterator remove null Exception, e:" + e);
                }
                it.next();
                it.remove();
                System.out.println("after iterator remove instance1, size=" + InsMap.size());
                InsMap.put(instance4, 4);
                System.out.println("after iterator put instance4, size=" + InsMap.size());
                isTest = false;
            }
            Entry<Instance, Integer> entry = it.next();
            System.out.println("entry=" + entry);
        }


        Instance removeInstance = new Instance("b", 21);
        if (InsMap.containsKey(removeInstance)) {
            InsMap.remove(removeInstance);
            System.out.println(InsMap);
        }
    }
}