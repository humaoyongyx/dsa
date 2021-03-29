package issac.study.dsa.lc;

/**
 * @author issac.hu
 */
public class ReverseInt {

    public static void main(String[] args) {
        int x = -123;
        System.out.println(x);
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int positiveOF = Integer.MAX_VALUE % 10;
        int negativeOF = Integer.MIN_VALUE % 10;
        int rev = 0;
        while (x != 0) {
            int ones = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE && ones > positiveOF)) return 0;//溢出
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && ones < negativeOF)) return 0;//溢出
            rev = rev * 10 + ones;
        }
        return rev;
    }

}
