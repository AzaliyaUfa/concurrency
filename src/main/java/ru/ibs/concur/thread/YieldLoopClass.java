package ru.ibs.concur.thread;

import java.util.LinkedList;
import java.util.Queue;

public class YieldLoopClass implements Runnable {

    private final Queue<String> msgQueue = new LinkedList<>();

    private final int msgCount;

    public YieldLoopClass(int msgCount) {
        this.msgCount = msgCount;
    }

    @Override
    public void run() {
        int count = 0;
        System.out.println(Thread.currentThread().getName() + " - Побочный поток с методом yield() в цикле начал свою работу.");
        while (!Thread.currentThread().isInterrupted()) { // пока поток запущен
            if (msgQueue.isEmpty()) { // Проверяем наличие в очереди сообщений
                System.out.println(Thread.currentThread().getName() + " - сообщений в очереди нет, поэтому побочный поток с методом yield() в цикле уступает свою очередь.");
                Thread.yield(); //Передать управление другим потокам
            } else {
                System.out.println("Получено сообщение: " + msgQueue.poll()); // возвращаем полученное сообщение и очищаем очередь
                count++;
            }
            try {
                Thread.sleep(100); // проверка каждые 100мс
            } catch (InterruptedException e) {
                if(count == msgCount) {
                    System.out.println(Thread.currentThread().getName() + " - Побочный поток с методом yield() в цикле закончил свою работу.");
                    break;
                }
            }
        }
    }

    public void addMsg(String msg) {
        this.msgQueue.add(msg);
    }
}
