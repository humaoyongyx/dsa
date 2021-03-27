package issac.study.dsa.lc;

/**
 * @author issac.hu
 */
public class BitTest {

    public static void main(String[] args) {

        System.out.println(test(15));
        System.out.println(is2N(4));
     }

    public static boolean is2N(int n) {
        return test(n) == 1;
    }

    public static int test(int num) {
        if (num == 0) {
            return 0;
        }
        int i = 1;
        while ((num = (num - 1) & num) != 0) {
            i++;
        }
        return i;
    }
}
