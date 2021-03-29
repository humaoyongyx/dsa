package issac.study.dsa.lc;

/**
 * @author issac.hu
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(isPalindrome(111));
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
