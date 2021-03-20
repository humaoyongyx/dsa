package issac.study.dsa.sort;

import issac.study.dsa.sort.base.AbstractSort;


/**
 * @author issac.hu
 */
public class QuickSort extends AbstractSort {

    @Override
    protected int[] sort(int[] disOrderArr) {
        return quickSort(disOrderArr, 0, disOrderArr.length - 1);
    }

    public int[] quickSort(int[] disOrderArr, int left, int right) {
        if (left < right) {
            int index = partition(disOrderArr, left, right);
            quickSort(disOrderArr, left, index - 1);
            quickSort(disOrderArr, index + 1, right);
        }
        return disOrderArr;
    }

    private int partition(int[] disOrderArr, int left, int right) {
        //在left位置挖坑
        int pivot = disOrderArr[left];
        //如果left==right那么说明只有一个，如果是至少两个的数，那么肯定是小于
        while (left < right) {
            //从right来比较，这个是重点，如果从left开始的话，会掉入坑中
            //由于要一道right<right其实是恒等的,可以去掉
            while (left < right && disOrderArr[right] > pivot) {
                right--;
            }
            //关键，如果小于，说明还在移动过程中，因为如果一旦是等于，那么说明left和right已经碰头了
            if (left < right) {
                disOrderArr[left++] = disOrderArr[right];
            }
            while (left < right && disOrderArr[left] <= pivot) {
                left++;
            }
            //这个算法的技巧其实本质上还是，将小的往left移动，大的往right移动，通过left和right分别指向坑来移动
            if (left < right) {
                disOrderArr[right--] = disOrderArr[left];
            }
        }
        //最后的指针一定是重复了
        disOrderArr[left] = pivot;
        return left;
    }
}
