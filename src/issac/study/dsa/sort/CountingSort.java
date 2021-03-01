package issac.study.dsa.sort;

import issac.study.dsa.sort.base.AbstractSort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author issac.hu
 */
public class CountingSort extends AbstractSort {
    @Override
    protected int[] sort(int[] disOrderArr) {
        int length = disOrderArr.length;
        int max = Arrays.stream(disOrderArr).max().getAsInt();
        int[] bucketArr = new int[max + 1];
        Arrays.fill(bucketArr, 0);
        for (int i = 0; i < length; i++) {
            Integer valAsKey = disOrderArr[i];
            bucketArr[valAsKey]++;
        }
        int[] sortArr = new int[length];
        int bucketLength = bucketArr.length;
        int cur = 0;
        for (int i = 0; i < bucketLength; i++) {
            int num = bucketArr[i];
            for (int j = 0; j < num; j++) {
                sortArr[cur] = i;
                cur++;
            }
        }
        return sortArr;
    }
}
