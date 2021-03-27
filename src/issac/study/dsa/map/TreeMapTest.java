package issac.study.dsa.map;

import java.util.TreeMap;

/**
 * 基于红黑树
 *
 * @author issac.hu
 */
public class TreeMapTest {
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        test0();
        ;
    }

    public static void test0() {
        treeMap.put(2, 2);
        treeMap.put(3, 3);
        treeMap.put(1, 1);
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.firstEntry());
    }
}
