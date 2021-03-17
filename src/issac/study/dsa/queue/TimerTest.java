package issac.study.dsa.queue;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author issac.hu
 */
public class TimerTest {

    static Timer timer = new Timer();

    public static void main(String[] args) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

            }
        },1, 1000);


    }
}
