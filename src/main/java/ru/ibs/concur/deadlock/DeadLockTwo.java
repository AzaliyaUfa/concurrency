package ru.ibs.concur.deadlock;

public class DeadLockTwo implements Runnable {

    private String lock1;
    private String lock2;

    public DeadLockTwo(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println("DeadLockTwo держит монитор " + lock2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("DeadLockTwo ждёт освобождения монитора " + lock1);
            synchronized (lock1) {
                System.out.println("DeadLockTwo держит мониторы " + lock1 + ", " + lock2);
            }
        }
    }
}
