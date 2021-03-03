package issac.study.dsa.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author issac.hu
 */
public class TestReentrantLock {

    public static int num;
    public static volatile int vNum;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static ReentrantLock reentrantLock = new ReentrantLock();
    /**
     * 读写锁，比ReentrantLock语义更细，也即多个线程读的时候：不互斥，而其他读和写需要互斥
     * 而ReentrantLock无论读和写都是要锁的
     */
    ReentrantReadWriteLock reentrantReadWriteLock;

    public static void main(String[] args) {

        testNum(() -> {
            increment();
        });
        System.out.println("plain num=" + num);
        testNum(() -> {
            syncIncr();
        });
        System.out.println("sync num=" + num);
        testNum(() -> {
            incrementV();
        });
        System.out.println("vol num=" + vNum);
        testNum(() -> {
            lockIncr();
        });
        System.out.println("lock num=" + num);
        testNum(() -> {
            incrAV();
        });
        System.out.println("av=" + atomicInteger.get());

    }

    private static void testNum(Incr incr) {
        num = 0;
        vNum = 0;
        atomicInteger.set(0);
        int threadNum = 10;
        List<Thread> threadList = new ArrayList<>(threadNum);
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> {
                incr.incr();
                countDownLatch.countDown();
            });
            threadList.add(thread);
        }

        threadList.stream().forEach(it -> it.start());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void increment() {
        //循环次数要大一点，否则没有效果
        for (int i = 0; i < 10000; i++) {
            num++;
        }
    }

    public static synchronized void syncIncr() {
        increment();
    }

    public static void lockIncr() {
        reentrantLock.lock();
        try {
            increment();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void incrementV() {
        //循环次数要大一点，否则没有效果
        for (int i = 0; i < 10000; i++) {
            vNum++;
        }
    }

    public static void incrAV() {
        //循环次数要大一点，否则没有效果
        for (int i = 0; i < 10000; i++) {
            atomicInteger.incrementAndGet();
        }
    }

    public interface Incr {
        void incr();
    }

}
