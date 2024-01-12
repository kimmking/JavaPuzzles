package io.github.kimmking.javapuzzles;

import java.lang.reflect.Field;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/1/12 19:34
 */
public class JavaPuzzle2 {
    public static void main(String[] args) {

        hackInteger(5,7);

        Integer x = 5;
        System.out.println("x = " + x);  // x == 7

        System.out.println("x = " + 5);  // x == 5,, javap看了一下，直接编译器优化成一个字符串了"x = 5"

        hackInteger(5,5);

         // -Djava.lang.Integer.IntegerCache.high=127
        //hackInteger(300,7);
        Integer y = 300;
        System.out.println("y = " + y);  // x == 7
        //hackInteger(300,300);
    }

    private static void hackInteger(int i, int j) {

        Class<?> cacheClass = Integer.class.getDeclaredClasses()[0];
        //System.out.println(cacheClass);
        try {
            Field cache = cacheClass.getDeclaredField("cache");
            cache.setAccessible(true);
            Integer[] ints = (Integer[]) cache.get(null);
            ints[128+i] = j;
            //System.out.println(ints[128+5]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}