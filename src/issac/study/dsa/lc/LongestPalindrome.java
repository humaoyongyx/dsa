package issac.study.dsa.lc;

/**
 * @author issac.hu
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "ac";
        System.out.println(longestPalindrome(s));
        System.out.println(isPalindrome(111));
        System.out.println(test(s));
    }


    /**
     * [i,j) i,j+1
     * s.substring(i,j);
     * <p>
     * P(i,j)= P(i+1,j-1) && Si==Sj
     * i<=j;
     * i==j的时候
     * <p>
     * s.length==1,P(i,j)==true
     * s.length==2,P(i,j)==Si==Sj
     * <p>
     * <p>
     * <p>
     * dp
     *
     * @return
     */
    public static String test(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String result = s.charAt(0) + "";
        for (int l = 0; l < length; l++) {
            for (int i = 0; i + l < length; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && (j - i + 1) > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    /**
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.charAt(0) + "";
        }
        int length = s.length();
        int start = 0, end = 1;
        int mid = 0;
        while (++mid < length - 1) {
            Character midChar = s.charAt(mid);
            boolean canEq = true;
            int curR = mid, curL = mid;
            for (int l = mid, r = mid; l >= 0 || r <= length - 1; ) {
                Character charAtR = r <= length - 1 ? s.charAt(r) : null;
                Character charAtL = l >= 0 ? s.charAt(l) : null;
                if ((midChar.equals(charAtR) || midChar.equals(charAtL)) && canEq) {
                    if (midChar.equals(charAtR)) {
                        curR = r <= length - 1 ? r + 1 : length;
                        if (curR - curL > end - start) {
                            start = curL;
                            end = curR;
                        }
                        r++;
                    }
                    if (midChar.equals(charAtL)) {
                        curL = l >= 0 ? l : 0;
                        if (r - l > end - start) {
                            start = curL;
                            end = curR;
                        }
                        l--;
                    }
                } else if (charAtR != null && charAtL != null && charAtR.equals(charAtL)) {
                    canEq = false;
                    curR = r + 1;
                    curL = l;
                    if (curR - curL > end - start) {
                        start = curL;
                        end = curR;
                    }
                    r++;
                    l--;
                } else {
                    break;
                }
            }
        }
        return s.substring(start, end);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int n = 1;
        int l = x;
        while ((l = l / 10) != 0) {
            n++;
        }

        for (int i = 1, j = n; i <= n; i++, j--) {
            int l1 = j;
            int l2 = i;
            int rev = x;
            int ori = x;
            while (l1-- > 1) {
                rev /= 10;
            }
            while (l2-- > 1) {
                ori /= 10;
            }
            ori %= 10;
            rev %= 10;
            if (ori != rev) {
                return false;
            }
            if (i == j) {
                break;
            }

        }
        return true;
    }
}
