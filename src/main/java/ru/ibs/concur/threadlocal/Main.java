package ru.ibs.concur.threadlocal;


import ru.ibs.concur.thread.ThreadColor;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CounterClass counterClass = new CounterClass();

        Thread t1 = new Thread(counterClass, ThreadColor.ANSI_BLUE.getThreadName());
        Thread t2 = new Thread(counterClass, ThreadColor.ANSI_PURPLE.getThreadName());
        Thread t3 = new Thread(counterClass, ThreadColor.ANSI_GREEN.getThreadName());

        t1.start();
        t2.start();
        t3.start();



        /*ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.submit(tlClass);
        }

        executor.shutdown();*/
    }
}