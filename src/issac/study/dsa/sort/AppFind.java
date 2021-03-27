package issac.study.dsa.sort;

import java.util.Arrays;

/**
 * @author issac.hu
 */
public class AppFind {

    public static void main(String[] args) {
        int[] randomArr = AppSort.getRandomArr(10);
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sort(randomArr);
        int[] distinct = Arrays.stream(sort).distinct().toArray();
        System.out.println(Arrays.toString(distinct));
        System.out.println(binQuery(distinct, 3));
        System.out.println(binQuery2(distinct, 3));

    }

    public static int binQuery(int[] sortedArr, int finder) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        return binQuery(sortedArr, 0, sortedArr.length - 1, finder);

    }

    private static int binQuery(int[] sortedArr, int begin, int end, int finder) {
        if (begin > end) {
            return -1;
        }
        int index = begin + (end - begin) / 2;
        int indexVal = sortedArr[index];
        if (indexVal == finder) {
            return index;
        } else {
            if (indexVal < finder) {
                begin = index + 1;
            } else {
                end = index - 1;
            }
            return binQuery(sortedArr, begin, end, finder);
        }

    }

    public static int binQuery2(int[] sortedArr, int finder) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        return binQuery2(sortedArr, 0, sortedArr.length - 1, finder);
    }

    private static int binQuery2(int[] sortedArr, int low, int high, int finder) {
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midVal = sortedArr[mid];
            if (midVal == finder) {
                return mid;
            } else if (midVal > finder) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
