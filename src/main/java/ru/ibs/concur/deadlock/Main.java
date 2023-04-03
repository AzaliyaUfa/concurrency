package ru.ibs.concur.deadlock;

public class Main {

    public static void main(String[] args) {

        String lock1 = "lock1";
        String lock2 = "lock2";

        DeadLockOne deadLockOne = new DeadLockOne(lock1, lock2);
        DeadLockTwo deadLockTwo = new DeadLockTwo(lock1, lock2);

        Thread thread1 = new Thread(deadLockOne);
        Thread thread2 = new Thread(deadLockTwo);

        thread1.start();
        thread2.start();

        /*Document doc1 = new Document("doc1");
        Document doc2 = new Document("doc2");

        new Thread(() -> doc1.printTheDifference(doc2)).start();
        new Thread(() -> doc2.printTheDifference(doc1)).start();*/

    }
}
