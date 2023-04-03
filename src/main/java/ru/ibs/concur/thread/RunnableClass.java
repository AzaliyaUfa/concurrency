package ru.ibs.concur.thread;

public class RunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Побочный поток реализации интерфейса Runnable начал свою работу.");
        System.out.println(Thread.currentThread().getName() + " - Идёт работа в побочном потоке реализации интерфейса Runnable.");
        System.out.println(Thread.currentThread().getName() + " - Побочный поток реализации интерфейса Runnable закончил свою работу.");
    }
}
