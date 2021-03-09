package issac.study.dsa.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author issac.hu
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.put(1);
        blockingQueue.take();
    }
}
