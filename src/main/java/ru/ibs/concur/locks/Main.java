package ru.ibs.concur.locks;



import ru.ibs.concur.thread.ThreadColor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage();

        Receiver receiver = new Receiver(storage);
        Sender sender = new Sender(storage);

        Thread receiverThread = new Thread(receiver, "receiverThread");
        Thread senderThread = new Thread(sender, "senderThread");

        receiverThread.start();
        senderThread.start();

        /*Lock lock = new ReentrantLock();
        LockClass lockClass = new LockClass(lock);

        Thread lockThread0 = new Thread(lockClass, ThreadColor.ANSI_GREEN.getThreadName());
        Thread lockThread1 = new Thread(lockClass, ThreadColor.ANSI_RED.getThreadName());
        lockThread0.start();
        lockThread1.start();*/

    }
}