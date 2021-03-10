package issac.study.dsa.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author issac.hu
 */
public class VolatileTest {

    static ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        //notVisible();
        //visible();
        visible2();
    }

    static int i = 0;

    private static void notVisible() throws InterruptedException {
        i = 0;
        new Thread(() -> {
            while (true) {
                if (i == 1) {
                    System.out.println("break");
                    break;
                }
            }
        }).start();
        Thread.sleep(1000);
        i = 1;
        System.out.println("complete");
    }

    private static void visible2() throws InterruptedException {
        i = 0;
        Object obj = new Object();
        new Thread(() -> {
            while (true) {
                /**
                 * reentrantLock 除了有同步的作用，还有volatile的作用，同步快里面的值将被变得线程可见
                 */
                reentrantLock.lock();
                if (i == 1) {
                    System.out.println("break");
                    break;
                }
                reentrantLock.unlock();
            }
        }).start();
        Thread.sleep(1000);
        // synchronized (obj){ 加在这里不行
        i = 1;
        //  }
        System.out.println("complete");
    }


    private static void visible() throws InterruptedException {
        i = 0;
        Object obj = new Object();
        new Thread(() -> {
            while (true) {
                /**
                 * synchronized 除了有同步的作用，还有volatile的作用，同步快里面的值将被变得线程可见
                 */
                synchronized (obj) {
                    if (i == 1) {
                        System.out.println("break");
                        break;
                    }
                }
            }
        }).start();
        Thread.sleep(1000);
        // synchronized (obj){ 加在这里不行
        i = 1;
        //  }
        System.out.println("complete");
    }
}
