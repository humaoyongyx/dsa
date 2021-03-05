package issac.study.dsa.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author issac.hu
 */
public class LockSupportTest {

    public static class MyT extends Thread {
        @Override
        public void run() {
            System.out.println("begin park" + this);
            LockSupport.park();
            System.out.println("im unpark" + this);
        }
    }

    public static void main(String[] args) {
        System.out.println("main begin...");
        MyT myT = new MyT();
        myT.start();
        System.out.println("main end...");
        LockSupport.unpark(myT);
        System.out.println("mt end...");
    }

}
