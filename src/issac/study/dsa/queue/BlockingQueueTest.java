package issac.study.dsa.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author issac.hu
 */
public class BlockingQueueTest {


    public static void main(String[] args) throws InterruptedException {

    }

    public static void testLinkedBlockingQueue() throws InterruptedException {
        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.put(1);
        blockingQueue.take();
    }

    public static void testArrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);
        blockingQueue.put(1);
        blockingQueue.take();
    }

    public static void testSynchronousQueue() throws InterruptedException {
        SynchronousQueue<Integer> blockingQueue = new SynchronousQueue<>();
        blockingQueue.put(1);
        blockingQueue.take();
    }
}
