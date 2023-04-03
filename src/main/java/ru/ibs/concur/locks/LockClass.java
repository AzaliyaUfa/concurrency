package ru.ibs.concur.locks;

import ru.ibs.concur.thread.ThreadColor;

import java.util.concurrent.locks.Lock;

public class LockClass implements Runnable {

    private int i;
    private Lock locker;

    public LockClass(Lock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        String threadColor = ThreadColor.getByThreadName(Thread.currentThread().getName()).getColor();
        doCount(threadColor);
    }

    private /*synchronized*/ void doCount(String threadColor) {
        locker.lock();
        try {
            for (i = 5; i > 0; i--) {
                System.out.println(threadColor + Thread.currentThread().getName() + ": i = " + i);
            }
        } catch (Exception e) {
            locker.unlock();
        }
        /*finally {
            locker.unlock();
        }*/
    }
}
