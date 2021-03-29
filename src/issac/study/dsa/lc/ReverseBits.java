package issac.study.dsa.lc;

/**
 * >>：带符号右移。正数右移高位补0，负数右移高位补1
 * >>>：无符号右移。无论是正数还是负数，高位通通补0
 * <<：是逻辑左移，右边补0，符号位和其他位一样要移动
 * <p>
 * System.out.println(Long.valueOf("11111111111111111111111111111111", 2));//-1
 * System.out.println(Integer.toBinaryString(-1));
 * System.out.println("-1 >>  1:" + Integer.toBinaryString(-1 >> 1));
 * System.out.println("-1 >>> 1:" + Integer.toBinaryString(-1 >>> 1));
 * System.out.println("-1 <<  1:" + Integer.toBinaryString(-1 << 1));
 * System.out.println("-1 << 32:" + Integer.toBinaryString(-1 << 32));//最好不要溢出
 *
 * @author issac.hu
 */
public class ReverseBits {

    public static void main(String[] args) {
        int n = 11;
        String s = Integer.toBinaryString(n);
        System.out.println(String.format("%032.0f", Double.parseDouble(s)));
        int i = reverseBits(n);
        System.out.println(String.format("%032.0f", Double.parseDouble(Integer.toBinaryString(i))));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 31 && n != 0; i++) {
            result = result | ((n & 1) << (31 - i));
            n = n >>> 1;
        }
        return result;
    }

}
