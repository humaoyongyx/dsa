package issac.study.dsa.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author issac.hu
 */
public class UnsafeTest {

    static final Unsafe unsafe;

    private volatile long state = 0;

    static final long stateOffset;

    static {
        try {
            Field field=Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe= (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        UnsafeTest unsafeTest = new UnsafeTest();
        boolean b = unsafe.compareAndSwapLong(unsafeTest, stateOffset, 0, 2);
        System.out.println(unsafeTest.state);
    }
}
