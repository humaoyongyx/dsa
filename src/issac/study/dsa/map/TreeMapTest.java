package issac.study.dsa.map;

import java.util.TreeMap;

/**
 * @author issac.hu
 */
public class TreeMapTest {
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        test0();
        ;
    }

    public static void test0() {

        treeMap.put(1, 2);
        treeMap.get(1);
    }
}
