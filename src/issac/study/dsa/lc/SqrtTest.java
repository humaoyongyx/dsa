package issac.study.dsa.lc;

/**
 * @author issac.hu
 */
public class SqrtTest {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(3));
        System.out.println(mySqrt(3, 0));
    }

    /**
     * double未必准确
     *
     * @param x
     * @param limit
     * @return
     */
    public static double mySqrt(double x, int limit) {
        double l = 0.1;
        if (limit > 0) {
            l = limit;
        }
        while (limit-- > -1) {
            l /= 10;
        }
        double start = 0;
        double end = x;
        double k = (end - start) / 2.0;
        while (Math.abs(k * k - x) > l) {
            double v = k * k;
            if (v > x) {
                end = k;
                k = (end - start) / 2.0;
            } else if (v == x) {
                return k;
            } else {
                start = k;
                k = (start + end) / 2.0;
            }
        }
        return k;
    }
}
