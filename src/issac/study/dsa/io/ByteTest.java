package issac.study.dsa.io;

import java.io.*;

/**
 * @author issac.hu
 */
public class ByteTest {

    static final String charset = "UTF-8";

    public static void main(String[] args) throws IOException {
        readTxt();
    }

    private static void readTxt() throws IOException {
        String path = ByteTest.class.getResource("").getPath();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "test.txt"), charset))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        }
    }

    /**
     * 大的二进制文件读取，如果只用缓存来存的化必然会有问题，最好的办法应该是分段读取，那么如何分段呢？（待学习）
     * todo
     * <p>
     * 这种方法也是一次性读取，只不过在读取的过程中，使用了buffer
     * ByteArrayOutputStream内部维护了一个可以扩容的数组
     *
     * @throws IOException
     */
    private static void readBytes2() throws IOException {
        String path = ByteTest.class.getResource("").getPath();
        System.out.println(path);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "test.txt"));
             ByteArrayOutputStream baos = new ByteArrayOutputStream(1024)) {
            byte[] data = new byte[10];
            int length = bis.read(data);
            while (length != -1) {
                baos.write(data, 0, length);
                length = bis.read(data);
            }
            System.out.println(new String(baos.toByteArray()));
        }
    }

    /**
     * 一次性读取
     *
     * @throws IOException
     */
    private static void readByteFile() throws IOException {
        String path = ByteTest.class.getResource("").getPath();
        System.out.println(path);
        try (FileInputStream fis = new FileInputStream(path + "test.txt")) {
            //一次性读取
            byte[] data = new byte[fis.available()];
            int length;
            length = fis.read(data);
            if (length != -1) {
                //默认为UTF-8
                System.out.println(new String(data));
            }
        }
    }
}
