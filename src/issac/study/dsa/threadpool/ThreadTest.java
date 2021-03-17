package issac.study.dsa.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * @author issac.hu
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        thread.isInterrupted();
        System.gc();
        Runtime.getRuntime().gc();
        Runtime.getRuntime().freeMemory();
        while (true){
            TimeUnit.SECONDS.sleep(100);
        }
    }
}
