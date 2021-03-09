package issac.study.dsa.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author issac.hu
 */
public class QueTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Xx");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        executorService.shutdown();
        System.out.println(-1<<29);

    }
}
