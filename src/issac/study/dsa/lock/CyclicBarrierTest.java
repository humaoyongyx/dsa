package issac.study.dsa.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 类比：CountDownLatch 一次性
 * cyclicBarrier.await();必须在线程里面
 *
 * @author issac.hu
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println(Thread.currentThread() + " 完成最后任务");
        });

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("first round" + Thread.currentThread());
                try {
                    cyclicBarrier.await();
                    Thread.sleep(1000);
                    System.out.println("second round" + Thread.currentThread());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }
}
