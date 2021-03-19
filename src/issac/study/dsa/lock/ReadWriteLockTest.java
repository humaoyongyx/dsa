package issac.study.dsa.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author issac.hu
 */
public class ReadWriteLockTest {

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();
        readLock.lock();
        writeLock.lock();
        readLock.unlock();
        writeLock.unlock();
    }
}
