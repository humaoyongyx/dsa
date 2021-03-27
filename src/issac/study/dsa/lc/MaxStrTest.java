package issac.study.dsa.lc;

/**
 * @author issac.hu
 */
public class MaxStrTest {

    public static void main(String[] args) {

        String s1 = "ab123cd";
        String s2 = "a123456c";

        System.out.println(getMax(s1, s2));

    }

    public static String getMax(String s1, String s2) {
        if (s1 == null || s2 == null || "".equals(s1) || "".equals(s2)) {
            return "-1";
        }
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int beginG = 0;
        int endG = 0;
        for (int i = 0; i < s1Arr.length; i++) {
            int begin = i;
            int end = i;
            for (int j = 0; j < s2Arr.length; j++) {
                if (s1Arr[i] == s2Arr[j]) {
                    int nextI = i;
                    int nextJ = j;
                    while (nextI < s1.length() && nextJ < s2.length() && s1Arr[nextI] == s2Arr[nextJ]) {
                        nextI++;
                        nextJ++;
                    }
                    end = nextI;
                }
            }
            if (end - begin > endG - beginG) {
                beginG = begin;
                endG = end;
            }
        }
        if (endG - beginG == 0) {
            return "-1";
        }
        return s1.substring(beginG, endG);
    }
}
