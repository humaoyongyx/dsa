package issac.study.dsa.queue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author issac.hu
 */
public class ScheduleQueueTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("xx");
            }
        }, 10, TimeUnit.SECONDS);
        // scheduledExecutorService.shutdown();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleAtFixedRate");
            }
        }, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleWithFixedDelay");
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
}
