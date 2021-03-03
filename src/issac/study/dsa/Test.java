package issac.study.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author issac.hu
 */
public class Test {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 1);
        map.put("1", 1);
        map.get("1");

        ArrayList<Integer> list = new ArrayList<>(1);
        list.add(1);
        list.add(1, 12);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);

        Hashtable<Integer, Object> hashtable = new Hashtable<>();
        hashtable.put(1, 2);
        hashtable.get(1);

        ConcurrentHashMap<Integer, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 2);
        concurrentHashMap.get(1);

        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.getAndSet(1);
        atomicInteger.incrementAndGet();
    }
}
