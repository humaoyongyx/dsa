package issac.study.dsa;

import issac.study.dsa.sort.BubbleSort;
import issac.study.dsa.sort.CountingSort;
import issac.study.dsa.sort.base.Sort;

/**
 * @author issac.hu
 */
public class App {

    public static void main(String[] args) {
        //num=100000是个分水岭，测试的时候可以设置为10000和100000便于测试
        int num = 10000;
        int[] randomArr = getRandomArr(num);
        //当num达到10000以上的时候，排序变差
        Sort bubbleSort = new BubbleSort();
        bubbleSort.sort(randomArr, "bubble sort", false);
        //当num小于10000以下，创建数组的开销比较大，但是高于这之后性能稳定在50ms左右
        Sort countingSort = new CountingSort();
        countingSort.sort(randomArr, "counting sort", false);
    }

    public static int[] getRandomArr(int num) {
        int[] randomArr = new int[num];
        for (int i = 0; i < num; i++) {
            randomArr[i] = Double.valueOf(Math.random() * num).intValue();
        }
        return randomArr;
    }

}
