package issac.study.dsa.sort;

import issac.study.dsa.sort.base.AbstractSort;

/**
 * 冒泡排序
 *
 * @author issac.hu
 */
public class BubbleSort extends AbstractSort {
    @Override
    protected int[] sort(int[] disOrderArr) {
        int length = disOrderArr.length;
        boolean sorted = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (disOrderArr[j] > disOrderArr[j + 1]) {
                    int temp = disOrderArr[j];
                    disOrderArr[j] = disOrderArr[j + 1];
                    disOrderArr[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return disOrderArr;
    }
}
