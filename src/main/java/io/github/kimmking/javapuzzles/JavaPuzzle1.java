package io.github.kimmking.javapuzzles;

/**
 * JavaPuzzle1&2:
 * 1. Java为了性能，所以缓存了一些常用的低位数字的Integer对象。降低CPU和内存占用。
 * 2. 这么做的结果就是导致Integer在低位和高位时，表现不一样。
 * 3. 更严重的看待这个问题，就是破坏了不可变性。
 * 4. 导致Puzzle2里的那个看起来没有副作用的代码，产生了严重副作用，并且是全JVM级的。
 * 5. 如果那个hack方法运行在一个JVM里，执行一次，后续的所有整形对象5，都会错误变成7来用。特别是在UT里。
 *
 * 讲了一些Java的语法糖。
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/1/12 19:39
 */
public class JavaPuzzle1 {
    public static void main(String[] args) {

        Integer a = 3; // Integer a = Integer.valueOf(3);
        Integer b = 3;
        System.out.println(" a == b : " + (a==b));

        Integer c = 300;
        Integer d = 300;
        System.out.println(" c == d : " + (c==d));

    }

}
