package issac.study.dsa.lock;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author issac.hu
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        // test1();
        test2();
    }

    /**
     * 没有异常
     * countDownLatch放在之前和之后的区别，我们一般放在最后，这样才能拿到最终的结果
     *
     * @throws InterruptedException
     */
    private static void test1() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                countDownLatch.countDown();
                try {
                    if (finalI == 2) {
                        Thread.sleep(5000);
                    } else {
                        Thread.sleep(1000);
                    }
                    System.out.println(Thread.currentThread() + new Date().toLocaleString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                //  countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread() + new Date().toLocaleString());
    }

    private static void test2() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {

                try {
                    if (finalI == 2) {
                        if (1 / 0 == 1) {
                            System.out.println("");
                        }
                      //  countDownLatch.countDown(); //这样会导致永远出不来
                    } else {
                        Thread.sleep(1000);
                    }
                    System.out.println(Thread.currentThread() + new Date().toLocaleString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //一定要这样处理，否则countDownLatch会有问题
                    //countDownLatch.countDown();
                }

            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread() + new Date().toLocaleString());
    }

}
