package issac.study.dsa.sort.base;

/**
 * @author issac.hu
 */
public interface Sort {
    /**
     * 排序一个无序的数组，并且返回一个有序的
     *
     * @param disOrderArr
     * @param name
     * @param showArr
     * @return
     */
    int[] sort(int[] disOrderArr, String name, boolean showArr);

    /**
     * 排序一个无序的数组，并且返回一个有序的
     * 默认showArr为false
     *
     * @param disOrderArr
     * @param name
     * @return
     */
    int[] sort(int[] disOrderArr, String name);
}
