package ru.ibs.concur.threadlocal;

import ru.ibs.concur.thread.ThreadColor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class CounterClass implements Runnable {

    private static Integer counter = 0;

    private static ThreadLocal<Integer> tlCounter = new ThreadLocal<>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /*private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };*/

    @Override
    public void run() {

        int localCounter = 0;

        String threadName = Thread.currentThread().getName();

        for (int i = 0; i < Math.random() * 10; i++) {
            try {
                System.out.println(ThreadColor.getByThreadName(threadName).getColor()
                        //+ threadName + ": some action" + sdf.get().parse(LocalDate.now().toString()));
                        + threadName + ": some action" + sdf.parse(LocalDate.now().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            counter++;
            if (tlCounter.get() == null) {
                tlCounter.set(0);
            }
            tlCounter.set(tlCounter.get() + 1);
            localCounter++;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printCounters(threadName);
        printCounters(threadName, localCounter);
    }

    private void printCounters(String threadName) {
        System.out.println(ThreadColor.ANSI_YELLOW.getColor() + threadName + ": Counter: " + counter);
        System.out.println(ThreadColor.ANSI_YELLOW.getColor() + threadName + ": ThreadLocalCounter: " + tlCounter.get());
    }

    private void printCounters(String threadName, Integer localCounter) {
        System.out.println(ThreadColor.ANSI_RED.getColor() + threadName + ": Counter: " + counter);
        System.out.println(ThreadColor.ANSI_RED.getColor() + threadName + ": LocalCounter: " + localCounter);
    }
}
