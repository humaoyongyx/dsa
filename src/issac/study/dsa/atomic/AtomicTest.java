package issac.study.dsa.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicReference
 * 出现aba问题
 * AtomicStampedReference
 * atomicinteger也会出现aba问题，但是对其是良性的，但是AtomicReference可能就不是良性的了
 *
 * @author issac.hu
 * Inmultithreadedcomputing, theABA problemoccurs during synchronization, when a location is read twice, has the same value for both reads, and "value is the same" is used to indicate "nothing has changed". However, another thread can execute between the two reads and change the value, do other work, then change the value back, thus fooling the first thread into thinking "nothing has changed" even though the second thread did work that violates that assumption.
 */
public class AtomicTest {

    AtomicStampedReference<AbaObject> abaObjectAtomicStampedReference = new AtomicStampedReference<>(new AbaObject("a"), 1);

    static class AbaObject {

        private String value;

        public AbaObject(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicReference<AbaObject> atomicReference = new AtomicReference<>();
        AbaObject a = new AbaObject("a");
        AbaObject b = new AbaObject("b");
        AbaObject c = new AbaObject("c");
        atomicReference.set(a);
        System.out.println(Thread.currentThread() + "->" + atomicReference.get().value);
        new Thread(() -> {
            AbaObject abaObject = atomicReference.get();
            assert abaObject == a;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //希望把a改成b
            boolean b1 = atomicReference.compareAndSet(abaObject, b);
            while (!b1) {
                AbaObject abaObject1 = atomicReference.get();
                b1 = atomicReference.compareAndSet(abaObject1, b);
            }
            System.out.println(Thread.currentThread() + "->" + atomicReference.get().value);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AbaObject abaObject = atomicReference.get();
            assert abaObject == a;
            //doSth
            abaObject.value = "X";
            atomicReference.compareAndSet(abaObject, c);
            atomicReference.compareAndSet(c, a);
            System.out.println(Thread.currentThread() + "->" + atomicReference.get().value);

        }).start();

        TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread() + "->" + atomicReference.get().value);

    }


}
