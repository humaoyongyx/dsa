package issac.study.dsa.queue;

import java.util.concurrent.*;

/**
 * @author issac.hu
 */
public class QueueTest {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 公平非公平 有界
         */
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2, false);
        arrayBlockingQueue.put(1);
        /**
         *两个独立锁 有界
         */
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.put(1);
        /**
         *逻辑上无解队列，有序
         */
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(1, Integer::compareTo);
        priorityBlockingQueue.put(2);
        priorityBlockingQueue.put(1);
        Integer take = priorityBlockingQueue.take();
        System.out.println(take);

        DelayQueue<Delay1> delayQueue = new DelayQueue<>();
        delayQueue.put(new Delay1(2));
        delayQueue.put(new Delay1(2));
        Delay1 take1 = delayQueue.take();
        System.out.println(take1);
    }

    static class Delay1 implements Delayed {
        private long value = 1;

        public Delay1(Integer value) {
            this.value = value * 1000 + System.currentTimeMillis();
        }


        @Override
        public long getDelay(TimeUnit unit) {
            return value - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            // return (int) (this.value - ((Delay1) o).value);
            return (int) (getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS));
        }
    }
}
