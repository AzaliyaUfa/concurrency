package ru.ibs.concur.thread;

public class InterruptedClass implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Побочный поток класса с прерыванием начал свою работу.");
        int counter = 0; // счетчик циклов
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Loop " + counter++);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " был прерван.");
        }
        System.out.println(Thread.currentThread().getName() + " - Побочный поток класса с прерыванием закончил свою работу.");
    }

   /* @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Побочный поток класса с прерыванием начал свою работу.");
        int counter = 0; // счетчик циклов
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Loop " + counter++);
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " был прерван.");
                System.out.println("Значение флага прерывания потока " + Thread.currentThread().getName() + " - " + Thread.currentThread().isInterrupted());    // вернёт false
                Thread.currentThread().interrupt();    // повторно сбрасываем состояние, либо
                // break; // мы можем сразу же в блоке catch выйти из цикла с помощью break
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Побочный поток класса с прерыванием закончил свою работу.");
    }*/
}
