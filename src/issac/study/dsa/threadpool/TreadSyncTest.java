package issac.study.dsa.threadpool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author issac.hu
 */
public class TreadSyncTest {


    public static void main(String[] args) throws InterruptedException {
        //go1();
        //go2();
        go3();
    }
    static Thread root = null;
    public static void go3() throws InterruptedException {


        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("loop end..");
        });
        Thread pre = new Thread(() -> {
            LockSupport.park();
            System.out.println(10);
            try {
                cyclicBarrier.await();
                LockSupport.park();
                System.out.println(10);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        for (int i = 9; i > 0; i--) {
            int finalI = i;
            Thread finalPre = pre;
            Thread next = new Thread(() -> {
                LockSupport.park();
                System.out.println(finalI);
                LockSupport.unpark(finalPre);
                try {
                    cyclicBarrier.await();
                    LockSupport.park();
                    System.out.println(finalI);
                    LockSupport.unpark(finalPre);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            pre.start();
            pre = next;
        }
        pre.start();
        LockSupport.unpark(pre);
        TimeUnit.SECONDS.sleep(3);
        LockSupport.unpark(pre);
    }

    public static void test() {

    }

    public static void go2() throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(100, true);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Integer take = arrayBlockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + "->" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "t" + i).start();
        }
        TimeUnit.SECONDS.sleep(3);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                int finalI = i;
                try {
                    arrayBlockingQueue.put(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void go1() throws InterruptedException {
        for (int i = 1; i < 3; i++) {
            Thread run = run();
            run.join();
            System.out.println("---");
        }
    }

    private static Thread run() {
        Thread pre = new Thread(() -> {
            try {
                System.out.println(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        for (int i = 2; i <= 10; i++) {
            Thread finalPre = pre;
            int finalI = i;
            Thread next = new Thread(() -> {
                try {
                    finalPre.join();
                    System.out.println(finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            pre.start();
            pre = next;
        }
        pre.start();
        return pre;
    }
}
