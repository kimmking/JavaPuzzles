package io.github.kimmking.javapuzzles;

import jdk.internal.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/1/15 06:52
 */
public class JavaPuzzle6 {

    protected static final String CONST_FIELD = "const string with 5"; // how to modify it to make it 6?

    public static void main(String[] args) {
        System.out.println(" before " + CONST_FIELD);

        // hack it
       // method1_for_jdk8_11();

       // method2_for_jdk8_17();

       method3_for_jdk8_17();

//        System.out.println(" after " + CONST_FIELD);
    }


    // --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED
    private static void method1_for_jdk8_11() {

        try {

            // remove modifier
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);

            Field field = null;
            field = JavaPuzzle6.class.getDeclaredField("CONST_FIELD");
            field.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, "const string with 6");

            System.out.println("field get: " + field.get(null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void method2_for_jdk8_17() {
        Method getDeclaredFields0 = null;
        try {
            getDeclaredFields0 = Class.class.getDeclaredMethod("getDeclaredFields0", boolean.class);
            getDeclaredFields0.setAccessible(true);
            Field[] fields = (Field[]) getDeclaredFields0.invoke(Field.class, false);
            Field modifiers = null;
            for (Field each : fields) {
                if ("modifiers".equals(each.getName())) {
                    modifiers = each;
                }
            }
            modifiers.setAccessible(true);

            Field field = null;
            field = JavaPuzzle6.class.getDeclaredField("CONST_FIELD");
            field.setAccessible(true);

            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, "const string with 6");

            System.out.println("field get: " + field.get(null));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void method3_for_jdk8_17() {
        Field field = null;
        try {
            field = JavaPuzzle6.class.getDeclaredField("CONST_FIELD");
            setFinalStatic(field, "const string with 6");
            System.out.println("field get: " + field.get(null));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // --add-exports=java.base/jdk.internal.access=ALL-UNNAMED
    // --add-exports=java.base/jdk.internal=ALL-UNNAMED
    // --add-exports=java.base/jdk.internal.misc=ALL-UNNAMED

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public static void setFinalStatic(Field field, Object value) {
        try {
            Object fieldBase = unsafe.staticFieldBase(field);
            long fieldOffset = unsafe.staticFieldOffset(field);
            unsafe.putObject(fieldBase, fieldOffset, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
