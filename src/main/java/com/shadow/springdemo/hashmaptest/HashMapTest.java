package com.shadow.springdemo.hashmaptest;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-05 16:14
 */
public class HashMapTest {
    public static void main(String[] args) {

        // 0001 0000
        int n  = 16;

        int hash = hash("test");
        System.out.println(hash);

        // &与运算：同为1的置1，凡是有不同的则置0
        int i = (n - 1) & hash;
        System.out.println(i);

        int i1 = hash % n;
        System.out.println(i1);

    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
