package issac.study.dsa.lc;

import java.math.BigInteger;

/**
 * @author issac.hu
 */
public class BitMapTest {
    static byte[] bitmap = new byte[4];

    public static void main(String[] args) {
        System.out.println(exist(128));
        System.out.println(exist(128));
        System.out.println(exist(128));

        BigInteger bigInteger = new BigInteger("0");
        System.out.println(bigInteger);
        bigInteger = bigInteger.setBit(1);
        System.out.println(bigInteger);
        BigInteger pow = bigInteger.pow(1024 * 8 * 4);
        System.out.println(bigInteger);
        System.out.println(pow);
        System.out.println(pow.shiftRight(1024 * 8 * 4 - 1));
    }

    /**
     * 计算正整数
     *
     * @param v
     * @return
     */
    public static boolean exist(int v) {
        int index = 0;
        int v0 = v;
        while ((v0 = v0 >> 8) != 0) {
            index++;
        }
        byte no = bitmap[index];
        byte noAt = (byte) (v % 8);
        if ((bitmap[index] = (byte) (no | 1 << noAt)) == no) {
            return true;
        }
        return false;
    }
}
