package com.zane.test.common.practice.pass;

/**
 * Author: luojinping
 * Date: 15/1/29
 * Time: 下午4:01
 */
public class PassByTest {
    public static void main(String[] args) {
        PassByTest passByTest = new PassByTest();
        passByTest.test();

        StringBuffer s = new StringBuffer("good");
        StringBuffer s2 = new StringBuffer("bad");
        test(s, s2);
        System.out.println(s);//9 ---------地址还是那个地址，没有被函数修改
        System.out.println(s2);//10 -------上同
    }

    public void foo(String t) {
        t = "World";
        t = t + "Test";
    }

    public void test() {
        String s = "Hello";
        foo(s);
        System.out.println(s); //prints "Hello". Why didn't it change?}
    }

    static void test(StringBuffer s, StringBuffer s2) {
        System.out.println(s);//1
        System.out.println(s2);//2
        s2 = s;//3
        s = new StringBuffer("new");//4
        System.out.println(s);//5
        System.out.println(s2);//6
        s.append("hah");//7
        s2.append("hah");//8
    }
}
