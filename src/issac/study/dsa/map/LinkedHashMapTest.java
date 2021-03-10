package issac.study.dsa.map;

import java.util.LinkedHashMap;

/**
 * @author issac.hu
 */
public class LinkedHashMapTest {
    static LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        test0();
        ;
        // test1();
    }

    public static void test1() {
        //如果不存在就调用，传入的函数，将key给这个函数
        Integer integer = linkedHashMap.computeIfAbsent(1, (k) -> {
            return k == 1 ? 11 : 10;
        });
        System.out.println(integer);

        Integer newV = linkedHashMap.computeIfPresent(1, (k, ov) -> {
            return ov == 11 ? 1 : 11;
        });
        System.out.println(newV);
        Integer v = linkedHashMap.get(1);
        linkedHashMap.put(1, 1);
        linkedHashMap.putIfAbsent(1, 1);
        System.out.println(v);

    }

    /**
     * hashmap node的结构：
     * <p>
     * static class Node<K,V> implements Map.Entry<K,V> {
     * final int hash;
     * final K key;
     * V value;
     * Node<K,V> next; 如果在hash的数组中重复，next!=null
     * <p>
     * 覆写了hashmap的
     * putVal 里面的newNode newTreeNode（红黑树）也即，默认会按照链表的顺序加入
     * <p>
     * linkNodeLast(p);
     * Entry<K,V> before, after; 双向链表
     * <p>
     * static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
     * TreeNode<K,V> parent;  // red-black tree links
     * TreeNode<K,V> left;
     * TreeNode<K,V> right;
     * TreeNode<K,V> prev;    // needed to unlink next upon deletion
     * boolean red;
     * <p>
     * linkedhashmap的有序
     */
    public static void test0() {
        //所谓linkedhashmap的有序，并不是说可以get下标，而是指迭代的时候的有序
        linkedHashMap.put(null, 2);
        linkedHashMap.get(1);
        linkedHashMap.entrySet().iterator();
    }

    public static void test2() {
        linkedHashMap = new LinkedHashMap<Integer, Integer>(2, 0.75F, true);
    }
}
