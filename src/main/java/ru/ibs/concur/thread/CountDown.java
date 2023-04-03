package ru.ibs.concur.thread;

public class CountDown implements Runnable {

    private int i;

    @Override
    public void run() {
        String threadColor;
        switch (Thread.currentThread().getName()) {
            case "Thread-0":
                threadColor = ThreadColor.ANSI_GREEN.getColor();
                break;
            case "Thread-1":
                threadColor = ThreadColor.ANSI_RED.getColor();
                break;
            case "Thread-2":
                threadColor = ThreadColor.ANSI_YELLOW.getColor();
                break;
            default:
                threadColor = ThreadColor.ANSI_PURPLE.getColor();
        }
        doCount(threadColor);
    }

    /*private void doCount(String threadColor) {
        synchronized (this) {
            for (i = 5; i > 0; i--) {
                System.out.println(threadColor + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }*/

    public synchronized void printMethod(String str) {
        try {
            System.out.println("Отправляем метод printMethod спать");
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
            System.out.println("Метод printMethod ожил");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }

    private synchronized void doCount(String threadColor) {
        for (i = 5; i > 0; i--) {
            System.out.println(threadColor + Thread.currentThread().getName() + ": i = " + i);
        }
    }


}
