package issac.study.dsa.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 逻辑
 * put 的时候，如果数量大于>capacity容量，就会阻塞，直到队列有调用 take
 * take的时候，如果队列为空的时候，将会阻塞，直到队列有put
 * 通俗一点就是：生产者和消费者
 * <p>
 * 如果生产者生产的东西已经满的时候，那么此时的生产者将会被阻塞。直到消费者消费。
 * 而对于消费者，当队列为空的时候，将会被阻塞，直到有生产者生成东西放进队列。
 *
 * @author issac.hu
 */
public class ArrayBlockingQueueTest {

    static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);

    public static void main(String[] args) throws InterruptedException {
        putQue();
        takeQue();
        blockingQueue.add(1);
    }

    public static void putQue() {
        new Thread(() -> {
            try {
                Thread currentThread = Thread.currentThread();
                System.out.println(currentThread + "before put");
                blockingQueue.put(1);
                blockingQueue.put(2);
                blockingQueue.put(3);
                System.out.println(currentThread + "after put");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }

    public static void takeQue() {
        new Thread(() -> {
            try {

                while (true) {
                    Thread.sleep(3000);
                    Thread currentThread = Thread.currentThread();
                    System.out.println(currentThread + "before take");
                    blockingQueue.take();
                    System.out.println(currentThread + "after take");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}