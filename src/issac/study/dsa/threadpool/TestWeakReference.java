package issac.study.dsa.threadpool;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class TestWeakReference {

    static Holder2 test = new Holder2();

    static class Holder2 {

    }

    static class Holder {
        private HashMap<Holder2, Integer> test2 = new HashMap<>();

        Holder(Holder2 i) {
            test2.put(i, 1);
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Holder finalize");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Holder holder = new Holder(test);
        holder = null;
        System.gc();
        while (true) {
            if (test!=null){
                ;;
            }
            Thread.sleep(10);
        }
    }


    //https://www.jianshu.com/p/964fbc30151a
    public static void testWeak() {
        WeakReference<Car> weakCar = new WeakReference<Car>(new Car(1, "#"));
        int i = 0;
        while (true) {
            Car car = weakCar.get();
            if (car != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
//            if (car == null) {
//                System.out.println("...");
//            }
        }
    }

}