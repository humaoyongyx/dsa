package issac.study.dsa.lc;

/**
 * @author issac.hu
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }

    /**
     * 假设 n=4
     * i>=2，切割长度j j > 0
     * i   | 1 | 2 | 3 | 4 |
     * f(i)| 0 | 1 | 2 | 4 |
     * j       | max(1*1,1*f(1)) | E max(1*2,1*f(2),2*1,,2*f(1))|
     * <p>        0<j<i;
     * 1<j<i-1;
     * <p>
     * <p>
     * f(i)=E max(j*(i-j),j*f(i-j)) 自顶向下
     * <p>
     * 2<= i <=n-2 从底往上 2层for
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
