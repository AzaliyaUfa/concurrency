package ru.ibs.concur.interstream;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage();

        Receiver receiver = new Receiver(storage);
        Sender sender = new Sender(storage);

        Thread receiverThread = new Thread(receiver, "receiverThread");
        Thread senderThread = new Thread(sender, "senderThread");

        receiverThread.start();
        senderThread.start();

    }

}
