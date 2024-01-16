package io.github.kimmking.javapuzzles;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/1/12 21:00
 */
public class JavaPuzzle3 {

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        System.out.println(abs(a) >= 0);
        a = 1000;
        System.out.println(abs(a) >= 0);
        a = -10000;
        System.out.println(abs(a) >= 0);
    }

    static int abs(int a) {
        if (a >= 0) return a;
        if (a == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (~a & Integer.MAX_VALUE) + 1;
    }

//    static int abs(int a) {
//        return (a^(a>>31)) - (a>>31);
//    }





}
