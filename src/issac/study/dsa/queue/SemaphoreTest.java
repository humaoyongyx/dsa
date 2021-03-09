package issac.study.dsa.queue;

import java.util.concurrent.Semaphore;

/**
 * @author issac.hu
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        semaphore.acquire();
        semaphore.release();
    }
}
