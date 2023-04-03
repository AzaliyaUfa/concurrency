package ru.ibs.concur.deadlock;

public class DeadLockOne implements Runnable {

    private String lock1;
    private String lock2;

    public DeadLockOne(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("DeadLockOne держит монитор " + lock1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("DeadLockOne ждёт освобождения монитора " + lock2);
            synchronized (lock2) {
                System.out.println("DeadLockOne держит мониторы " + lock1 + ", " + lock2);
            }
        }
    }
}
