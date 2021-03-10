package issac.study.dsa.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author issac.hu
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        hashMap.put(2, 2);
        hashMap.get(1);
        hashMap.remove(1);
        hashMap.containsKey(1);
        //遍历的时候如果不是用iterator遍历的话，删除和新增都会报ConcurrentModificationException
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        HashMap<MyKey, Integer> hashMap2 = new HashMap<>();
        hashMap2.put(new MyKey(), 2);
        hashMap2.put(new MyKey(), 3);
        for (Map.Entry<MyKey, Integer> entry : hashMap2.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 2);
        linkedHashMap.get(1);
        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {

        }
// 线程安全不管是get put 还是 iterator
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<Integer, Integer> entry : concurrentHashMap.entrySet()) {

        }
        concurrentHashMap.put(1, 1);
        concurrentHashMap.containsKey(1);
        concurrentHashMap.entrySet().iterator();
        concurrentHashMap.remove(1);
        concurrentHashMap.get(1);

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, 1);
        hashtable.get(1);
        hashtable.entrySet().iterator();

        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        objects.add(1);
        objects.get(1);
        objects.remove(1);
        objects.iterator();

        Vector vector = new Vector();

        Collections.synchronizedList(new ArrayList());
    }
}