package ru.ibs.concur.locks;

import ru.ibs.concur.thread.ThreadColor;

public class Storage {

    private int productAmount = 0;



    public synchronized int sendProduct() {
        String threadName = Thread.currentThread().getName();
        while (productAmount < 1) {
            try {
                System.out.println(ThreadColor.ANSI_GREEN.getColor() + threadName + ": Отсутствуют товары на складе");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productAmount--;
        System.out.println(ThreadColor.ANSI_GREEN.getColor() + threadName + ": Получателю отправлен 1 товар");
        System.out.println(ThreadColor.ANSI_GREEN.getColor() + threadName + ": Товаров на складе: " + productAmount);
        this.notify();
        return productAmount;
    }

    public synchronized void getProduct() {
        String threadName = Thread.currentThread().getName();
        while (productAmount >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productAmount++;
        System.out.println(ThreadColor.ANSI_YELLOW.getColor() + threadName + ": На склад поступил 1 товар");
        System.out.println(ThreadColor.ANSI_YELLOW.getColor() + threadName + ": Товаров на складе: " + productAmount);
        this.notify();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
