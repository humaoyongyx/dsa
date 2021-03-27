package issac.study.dsa.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author issac.hu
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {


    private int size;

    public LRUCache(int size) {
        super(16, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > this.size;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.get(1);
        lruCache.put(4, 4);
        Set<Map.Entry<Integer, Integer>> entries = lruCache.entrySet();
        for (Map.Entry<Integer, Integer> entry : lruCache.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
