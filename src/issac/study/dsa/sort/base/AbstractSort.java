package issac.study.dsa.sort.base;

import java.util.Arrays;

/**
 * @author issac.hu
 */
public abstract class AbstractSort implements Sort {

    @Override
    public int[] sort(int[] disOrderArr, String name) {
        return sort(disOrderArr, name, false);
    }

    @Override
    public int[] sort(int[] disOrderArr, String name, boolean showArr) {
        int[] copyOf = Arrays.copyOf(disOrderArr, disOrderArr.length);
        System.out.println(name + "---------------------------------");
        if (showArr) {
            System.out.println("before : " + Arrays.toString(copyOf));
        }
        long beginTime = System.currentTimeMillis();
        int[] sortArr = sort(copyOf);
        long endTime = System.currentTimeMillis();
        System.out.println("cost : " + (endTime - beginTime) + "ms");
        if (showArr) {
            System.out.println("after : " + Arrays.toString(sortArr));
        }
        System.out.println(name + "---------------------------------");
        return sortArr;
    }

    protected abstract int[] sort(int[] disOrderArr);

}
