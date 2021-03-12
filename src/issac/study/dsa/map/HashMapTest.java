package issac.study.dsa.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

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

        CopyOnWriteArraySet<Integer> sets = new CopyOnWriteArraySet<>();
    }


    public static class MyKey {
        private int hash = 1;

        public void setHash(int hash) {
            this.hash = hash;
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public String toString() {
            return hashCode() + "";
        }
    }

    /**
     * 如果hashmap的key的hashcode改变了，那么这个key就再也get不到了
     */
    public static void testKey() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer i = 1;
        hashMap.put(i, 1);
        System.out.println(hashMap);
        i++;
        System.out.println(hashMap);
        System.out.println(i);
        HashMap<MyKey, Integer> hashMap1 = new HashMap<>();
        MyKey key = new MyKey();
        hashMap1.put(key, 1);
        System.out.println(hashMap1);
        key.setHash(2);//还能get到吗？答案是否定的
        System.out.println(key);
        System.out.println(hashMap1.get(key));
        System.out.println(hashMap1);
    }
}