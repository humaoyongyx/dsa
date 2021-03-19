package issac.study.dsa.threadpool;

/**
 * @author issac.hu
 */
public class ThreadLocalTest {
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
    static InheritableThreadLocal<Integer> integerInheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            ThreadLocal<Integer> t = new ThreadLocal<>();
            t.set(i);
        }
        threadLocal.set(1111);
        System.out.println(threadLocal.get());

        Thread thread = new Thread();

    }
}
