package issac.study.dsa.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author issac.hu
 */
public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static class MyThread extends Thread {

        @Override
        public void run() {
            lock.lock();
            System.out.println(this + " im await please signal me...");
            try {
                TimeUnit.SECONDS.sleep(2);
                condition.await();
                System.out.println(this + " im wakeuped..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new MyThread().start();
        new MyThread().start();
        TimeUnit.SECONDS.sleep(3);
        try {
            lock.lock();
            System.out.println(Thread.currentThread() + "im help signal random");
            condition.signal();
        } finally {
            lock.unlock();
        }


    }
}
