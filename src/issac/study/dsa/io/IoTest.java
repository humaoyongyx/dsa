package issac.study.dsa.io;

import java.io.*;

/**
 * @author issac.hu
 */
public class IoTest implements Serializable, Cloneable {
    private MyClass myClass = new MyClass();


    @Override
    protected IoTest clone() throws CloneNotSupportedException {
        return (IoTest) super.clone();
    }

    public static void main(String[] args) throws Exception {

    }

    /**
     * 默认的是浅拷贝
     *
     * @throws CloneNotSupportedException
     */
    public static void testShallowCopy() throws CloneNotSupportedException {
        IoTest ioTest = new IoTest();
        IoTest clone = ioTest.clone();
        ioTest.myClass.setVal(3);
        System.out.println(clone.myClass.getVal());
    }

    public static void testDeepCopy() throws IOException, ClassNotFoundException {
        IoTest o = new IoTest();
        IoTest o1 = (IoTest) deepCopy(o);
        System.out.println(o.myClass == o1.myClass);
    }

    /**
     * 可以通过序列化的方式
     *
     * @param o
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deepCopy(Serializable o) throws IOException, ClassNotFoundException {
        if (o == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(o);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return objectInputStream.readObject();
        }
    }

    static class MyClass implements Serializable {

        private int val = 1;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

}


