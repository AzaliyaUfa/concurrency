package ru.ibs.concur.thread;

public class ThreadClass extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Побочный поток потомка Thread класса начал свою работу.");
        System.out.println(Thread.currentThread().getName() + " - Идёт работа в побочном потоке потомка Thread класса.");
        System.out.println(Thread.currentThread().getName() + " - Побочный поток потомка Thread класса закончил свою работу.");
    }
}
