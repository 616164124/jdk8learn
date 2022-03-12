package com.learn.test.hashmaptest;

/**
 * 哈希算法的实现
 * lies
 * 通过它的asii码值的和，进行取模，就值存到数组中
 * ASII码
 */
public class AscIITest {
    public static void main(String[] args) {
        char[] chars = "lies".toCharArray();
        System.out.println("lies".hashCode());

        for (int i = 0; i < chars.length; i++) {
            System.out.println((chars[i]+":"+(int)chars[i]));
        }
    }
}
