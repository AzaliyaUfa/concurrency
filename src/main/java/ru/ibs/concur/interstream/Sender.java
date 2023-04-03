package ru.ibs.concur.interstream;

public class Sender implements Runnable {

    private final Storage storage;

    public Sender(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            storage.getProduct();
        }
    }
}
