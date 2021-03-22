package issac.study.dsa.sort;

import issac.study.dsa.sort.base.Sort;

/**
 * @author issac.hu
 */
public class AppSort {

    public static void main(String[] args) {
        //num=100000是个分水岭，测试的时候可以设置为10000和100000便于测试
        int num = 10000;
        boolean showArr = true;
        int[] randomArr = getRandomArr(num);
        //当num达到10000以上的时候，排序变差
        Sort bubbleSort = new BubbleSort();
        bubbleSort.sort(randomArr, "bubble sort", showArr);
        //当num小于10000以下，创建数组的开销比较大，但是高于这之后性能稳定在50ms左右
        Sort countingSort = new CountingSort();
        countingSort.sort(randomArr, "counting sort", showArr);
        //quickSort 居然是最快的,当num>1000000 计数排序开始体现出性能
        Sort quickSort = new QuickSort();
        quickSort.sort(randomArr, "quick sort", showArr);
        //merge sort
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(randomArr, "merge sort", showArr);
    }

    public static int[] getRandomArr(int num) {
        int[] randomArr = new int[num];
        for (int i = 0; i < num; i++) {
            randomArr[i] = Double.valueOf(Math.random() * num).intValue();
        }
        return randomArr;
    }

}
