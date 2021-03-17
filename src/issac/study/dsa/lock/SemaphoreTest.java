package issac.study.dsa.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 限流
 * <p>
 * 共享锁，不可重入
 * <p>
 * 区别于 ReentrantLock 独占锁，可重入
 * <p>
 * 默认acquire 是acquireSharedInterruptibly 可中断的
 * release
 *
 * @author issac.hu
 */
public class SemaphoreTest {
    // 创建一个计数阈值为 5 的信号量对象
// 只能 5 个线程同时访问
    static Semaphore semp = new Semaphore(3);
    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                limitThread(finalI);
            }).start();
        }
    }

    /**
     * Thread[Thread-0,5,main]
     * Thread[Thread-2,5,main]
     * Thread[Thread-1,5,main]
     * 先执行三个，再执行后三个
     * Thread[Thread-3,5,main]
     * Thread[Thread-4,5,main]
     */
    public static void limitThread(final int i) {
        try { // 申请许可
            semp.acquire();
            try {
                // 业务逻辑
                if (i == 0) {
                    TimeUnit.SECONDS.sleep(5);
                } else {
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println(Thread.currentThread() + "->" + i);
            } catch (Exception e) {
            } finally {
             // 释放许可
                semp.release();
            }
        } catch (InterruptedException e) {
        }
    }
}
