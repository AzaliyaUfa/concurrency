package ru.ibs.concur.thread;

public class Main {

    static int a;
    static int b;

    public static void main(String[] args) {

        //System.out.println(Thread.currentThread().getName() + " - Главный поток начался.");

        Thread v1 = new Thread(() -> {
            a = 1;
            System.out.println("b = " + b);
        });
        Thread v2 = new Thread(() -> {
            b = 1;
            System.out.println("a = " + a);
        });

        v1.start();
        v2.start();

        /*CountDown countDown = new CountDown();
        Thread countDownThread0 = new Thread(countDown);
        Thread countDownThread1 = new Thread(countDown);
        countDownThread0.start();
        countDownThread1.start();
        countDown.printMethod("testStr");*/

        /*try {
            YieldLoopClass yieldLoop = new YieldLoopClass(5);
            Thread yieldLoopThread = new Thread(yieldLoop);
            yieldLoopThread.start();

            for (int i = 0; i < 3; i++) {
                YieldClass yieldClass = new YieldClass();
                Thread yieldClassThread = new Thread(yieldClass);
                yieldClassThread.start();
                yieldClassThread.join();
            }

            for (int i = 0; i < 5; i++) {
                yieldLoop.addMsg("New msg №" + i);
                System.out.println("Отправлено сообщение: New msg №" + i);
                Thread.sleep(300);
            }
            yieldLoopThread.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*ThreadClass threadClass = new ThreadClass();
        threadClass.start();
        try {
            threadClass.join();
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " - поток был прерван.");
        }

        RunnableClass runnable = new RunnableClass();
        Thread threadRunnable = new Thread(runnable);
        threadRunnable.start();
        try {
            threadRunnable.join();
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " - поток был прерван.");
        }*/

        /*threadRunnable.run();
        Thread innerClassThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " - Побочный поток безымянного внутреннего класса начал свою работу.");
                System.out.println(Thread.currentThread().getName() + " - Идёт работа в побочном потоке безымянного внутреннего класса.");
                System.out.println(Thread.currentThread().getName() + " - Побочный поток безымянного внутреннего класса закончил свою работу.");
            }
        });
        innerClassThread.start();

        Thread lambdaThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - Побочный поток лямбды начал свою работу.");
            System.out.println(Thread.currentThread().getName() + " - Идёт работа в побочном потоке лямбды.");
            System.out.println(Thread.currentThread().getName() + " - Побочный поток лямбды закончил свою работу.");
        });
        lambdaThread.start();*/

        /*LoopClass loop = new LoopClass();
        Thread loopThread = new Thread(loop);
        loopThread.start();
        try{
            Thread.sleep(5);
            loop.disable();
        }
        catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " - поток был прерван.");
        }*/

        /*InterruptedClass interrupted = new InterruptedClass();
        Thread interruptedThread = new Thread(interrupted);
        interruptedThread.start();
        try{
            Thread.sleep(1000);
            interruptedThread.interrupt();
        }
        catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " - поток был прерван.");
        }*/

        /*Thread longThread = new Thread(() -> {
            System.out.println("Поток " + Thread.currentThread() + " начал свою работу");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            System.out.println("Поток " + Thread.currentThread() + " завершил свою работу");
        });
        longThread.start();

        do {
            System.out.println("Ждём окончания выполнения потока " + longThread.getName());
            try {
                longThread.join(250);
            } catch (InterruptedException e) {
            }
        }
        while (longThread.isAlive());*/

        //System.out.println(Thread.currentThread().getName() + " - Главный поток закончился.");
    }
}
