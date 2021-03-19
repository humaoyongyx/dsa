package issac.study.dsa.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author issac.hu
 */
public class LinkedQueueTest {

    ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(10);

    static ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

    public static void main(String[] args) {
        concurrentLinkedQueue.offer(1);
        concurrentLinkedQueue.poll();
        int i = 1, d = i, s;
    }
}
