package issac.study.dsa.map;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author issac.hu
 */
public class ConcurrentHashMapTest {
    static ConcurrentHashMap<MyKey, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true){
                for (int i = 0; i < 100; i++) {
                    concurrentHashMap.put(new MyKey(), 1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            while (true){
                Iterator<Map.Entry<MyKey, Integer>> iterator = concurrentHashMap.entrySet().iterator();
                for (Map.Entry<MyKey, Integer> entry : concurrentHashMap.entrySet()) {
                    System.out.print(entry.getValue());
                }
                System.out.println("0------");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }


}
