package issac.study.dsa.threadpool;

import java.util.concurrent.*;

/**
 * @author issac.hu
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        testSyncTake();
        testSynchronousQueue();
        testSyncTake();
    }

    public static void testThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread());
            }

        });
        /**
         * 如果设置了true随着main执行结束而结束.
         * 而非daemon线程，即使主线程结束了,它依然会执行
         */
        // thread.setDaemon(true);
        thread.start();
    }


    public static void testThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "hello world";
            }
        });
        System.out.println("shutdown");
        executorService.shutdown();
        System.out.println("shutdown");
        submit.get();
    }

    public static void testThreadPool0() {
        /**
         * new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>())
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        /**
         * new FinalizableDelegatedExecutorService
         *             (new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         */
        Executors.newSingleThreadExecutor();
        /**
         * new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new SynchronousQueue<Runnable>())
         */
        Executors.newCachedThreadPool();

    }

    static SynchronousQueue<Integer> sQue = new SynchronousQueue<>();

    public static void testSynchronousQueue() throws InterruptedException {
        new Thread(() -> {

            try {
                while (true) {
                    Thread currentThread = Thread.currentThread();
                    System.out.println(currentThread + "before put...");
                    sQue.put(1);
                    System.out.println(currentThread + "after put...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }

    public static void testSyncTake() {
        new Thread(() -> {

            try {
                Thread currentThread = Thread.currentThread();
                System.out.println(currentThread + "before take...");
                sQue.take();
                System.out.println(currentThread + "after take...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }
}
