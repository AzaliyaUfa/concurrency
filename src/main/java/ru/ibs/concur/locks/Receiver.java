package ru.ibs.concur.locks;

import ru.ibs.concur.thread.ThreadColor;

public class Receiver implements Runnable {

    private final Storage storage;

    public Receiver(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            storage.sendProduct();
            System.out.println(ThreadColor.ANSI_BLUE.getColor() + "Получателю поступил товар №" + i);
        }
    }
}
