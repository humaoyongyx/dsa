package issac.study.dsa.lc;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author issac.hu
 */
public class ZStr {

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int j = 0; j < numRows; j++) {
            int c = j;
            int ct = 1;
            int ct2 = 0;
            while (c < chars.length) {
                int pos = (c - ct2) % numRows;
                if (pos == 0 || (pos == numRows - 1)) {
                    result.append(chars[c]);
                } else {
                    result.append(chars[c]);
                    int n1 = c + (numRows - j - 1) * 2;
                    if (n1 < chars.length) {
                        result.append(chars[n1]);
                    }
                }
                c = c + numRows * 2 - 2;
                ct2 = (numRows - 2) * ct;
                ct++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);
        System.out.println(Integer.MAX_VALUE);
    }
}
