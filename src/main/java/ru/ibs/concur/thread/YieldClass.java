package ru.ibs.concur.thread;

public class YieldClass implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Побочный поток с методом yield() начал свою работу.");
        System.out.println(Thread.currentThread().getName() + " - Побочный поток с методом yield() уступает свою очередь.");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " - Побочный поток с методом yield() закончил свою работу.");
    }
}
