package io.github.kimmking.javapuzzles;

/**
 * -XX:hashCode=2
 * https://hg.openjdk.org/jdk8u/jdk8u/hotspot/file/87ee5ee27509/src/share/vm/runtime/synchronizer.cpp#l555
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/1/12 21:01
 */
public class JavaPuzzle4 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Object o = new Object();
            System.out.println(i + " => " + o.hashCode());
            System.out.println(i + " => " + System.identityHashCode(o));
        }

    }

}
