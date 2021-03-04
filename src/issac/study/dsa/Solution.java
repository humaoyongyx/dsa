package issac.study.dsa;

class Solution {

    public static void main(String[] args) {
        int[] res = new int[11];
        for (int i = 0; i <= 10; i++) {
            res[i] = res[i >> 1] + (i & 1);
            System.out.println(i + "->" + res[i]);
        }


    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}