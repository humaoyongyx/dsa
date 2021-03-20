package issac.study.dsa.sort;

import issac.study.dsa.sort.base.AbstractSort;

import java.util.Arrays;

/**
 * divide and conquer 分而治之
 *
 * @author issac.hu
 */
public class MergeSort extends AbstractSort {
    @Override
    protected int[] sort(int[] disOrderArr) {
        return divide(disOrderArr);
    }

    public int[] divide(int[] disOrderArr) {
        if (disOrderArr.length < 2) {
            return disOrderArr;
        }
        int middle = disOrderArr.length / 2;
        int[] sortLeft = Arrays.copyOfRange(disOrderArr, 0, middle);
        int[] sortRight = Arrays.copyOfRange(disOrderArr, middle, disOrderArr.length);
        return sortSlice(divide(sortLeft), divide(sortRight));
    }

    private int[] sortSlice(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, i = 0;
        while (l < left.length || r < right.length) {
            int r0 = r == right.length ? r - 1 : r;
            while (l < left.length && left[l] <= right[r0]) {
                result[i++] = left[l++];
            }
            int l0 = l == left.length ? l - 1 : l;
            while (r < right.length && right[r] <= left[l0]) {
                result[i++] = right[r++];
            }
            while (l < left.length && left[l] > right[r0] && r == right.length) {
                result[i++] = left[l++];
            }
            while (r < right.length && right[r] > left[l0] && l == left.length) {
                result[i++] = right[r++];
            }
        }
        return result;
    }
}
