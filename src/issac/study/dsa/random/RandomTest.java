package issac.study.dsa.random;

import java.util.Random;

/**
 * @author issac.hu
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
