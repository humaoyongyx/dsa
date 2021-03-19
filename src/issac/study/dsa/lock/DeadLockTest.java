package issac.study.dsa.lock;

/**
 * @author issac.hu
 */
public class DeadLockTest {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread() + "im in");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "please unlock");
                synchronized (lock2) {
                    System.out.println("not be exe..");
                }
            }
        },"lock1").start();

        new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread() + "im in");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "please unlock");
                synchronized (lock1) {
                    System.out.println("not be exe..");
                }
            }
        },"lock2").start();
    }
}
