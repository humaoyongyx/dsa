package issac.study.dsa.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * @author issac.hu
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        //testInterrupted();
        //testInterrupted2();
        testInterrupted3();
    }

    /**
     * 这里会退不出去
     *
     * @throws InterruptedException
     */
    private static void testInterrupted3() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        System.out.println("inner thread.isInterrupted()" + Thread.currentThread().isInterrupted());
                        //如果想要退出去，那么还需要调用
                        //  Thread.currentThread().interrupt();
                    }
                    System.out.println("inner thread.isInterrupted()" + Thread.currentThread().isInterrupted());
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("thread.isInterrupted()" + thread.isInterrupted());
        System.out.println("thread.isInterrupted()" + thread.isInterrupted());
    }


    private static void testInterrupted2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        System.out.println("inner thread.isInterrupted()" + Thread.interrupted());
                    }
                    System.out.println("inner thread.isInterrupted()" + Thread.interrupted());
                }
            }
        });

        thread.start();
        thread.interrupt();
        System.out.println("thread.isInterrupted()" + thread.isInterrupted());
        System.out.println("thread.isInterrupted()" + thread.isInterrupted());
    }

    /**
     *
     */
    private static void testInterrupted() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    for (long i = 0; i < Integer.MAX_VALUE * 2L; i++) {
                        ;
                    }
                    System.out.println("inner thread.isInterrupted()" + Thread.interrupted());
                }
            }
        });

        thread.start();
        thread.interrupt();
        System.out.println("thread.isInterrupted()" + thread.isInterrupted());
        System.out.println("thread.isInterrupted()" + thread.isInterrupted());
    }
}
