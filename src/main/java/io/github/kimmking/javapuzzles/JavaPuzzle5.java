package io.github.kimmking.javapuzzles;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/1/12 21:26
 */
public class JavaPuzzle5 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        testMath();
        long end = System.currentTimeMillis();
        System.out.println(" testMath : " + (end-start) + " ms");

         start = System.currentTimeMillis();
        testStrictMath();
         end = System.currentTimeMillis();
        System.out.println(" testStrictMath : " + (end-start) + " ms");
    }

    private static void testMath() {
        for (int i = 0; i < 1000_0000; i++) {
            double r = Math.sqrt(i);
        }
    }

    private static void testStrictMath() {
        for (int i = 0; i < 1000_0000; i++) {
            double r = StrictMath.sqrt(i);
        }
    }

}
