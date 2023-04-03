package ru.ibs.concur.thread;

public class LoopClass implements Runnable {

    private boolean isActive = true;

    void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Побочный поток класса с циклом начал свою работу.");
        int counter = 0; // счетчик циклов
        while (isActive) {
            System.out.println("Loop " + counter++);
        }
        System.out.println(Thread.currentThread().getName() + " - Побочный поток класса с циклом закончил свою работу.");
    }

}
