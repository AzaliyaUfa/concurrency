package ru.ibs.concur.interstream;

import ru.ibs.concur.thread.ThreadColor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    private int productAmount = 0;
    private ReentrantLock locker;
    private Condition condition;

    public Storage() {
        locker = new ReentrantLock(); // создаем блокировку
        condition = locker.newCondition(); // получаем условие, связанное с блокировкой
    }

    public /*synchronized*/ int sendProduct() {
        locker.lock();
        String threadName = Thread.currentThread().getName();

        try {
            // пока нет доступных товаров на складе, ожидаем
            while (productAmount < 1) {
                System.out.println(ThreadColor.ANSI_GREEN.getColor() + threadName + ": Отсутствуют товары на складе");
                condition.await();
            }
            productAmount--;
            System.out.println(ThreadColor.ANSI_GREEN.getColor() + threadName + ": Получателю отправлен 1 товар");
            System.out.println(ThreadColor.ANSI_GREEN.getColor() + threadName + ": Товаров на складе: " + productAmount);
            // сигнализируем
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
        return productAmount;
    }

    public /*synchronized*/ void getProduct() {
        locker.lock();
        String threadName = Thread.currentThread().getName();
        try {
            // пока на складе 3 товара, ждем освобождения места
            while (productAmount >= 3) {
                condition.await();
            }
            productAmount++;
            System.out.println(ThreadColor.ANSI_YELLOW.getColor() + threadName + ": На склад поступил 1 товар");
            System.out.println(ThreadColor.ANSI_YELLOW.getColor() + threadName + ": Товаров на складе: " + productAmount);
            condition.signalAll();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
