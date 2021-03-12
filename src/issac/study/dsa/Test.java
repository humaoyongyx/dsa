package issac.study.dsa;

/**
 * @author issac.hu
 */
public class Test {
    private int i;
    private static int is;

    public class cl1 {

        public void test() {
            Test.this.i = 1;
            is = 1;
        }

    }

    public static class cl2 {
        public void test() {
            Test.main(new String[]{"1"});
            is = 1;
        }

        public static void main(String[] args) {

        }
    }

    public static void main(String[] args) {
    }
}
