package ru.ibs.concur.executor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // Определяем пул из трех потоков
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Список ассоциированных с Callable задач Future
        List<Future<String>> futures = new ArrayList<>();

        // Создаём экземпляр Callable класса
        Callable<String> callable = new CallableClass();

        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(startTime);

        for (int i = 0; i < 5; i++) {
            // Стартуем поток, возвращающий объект Future
            // по аналогии с someThread.start();
            Future<String> future = executor.submit(callable);
            //System.out.println("future done? " + future.isDone());
            futures.add(future);
        }

        for (Future<String> future : futures) {
            try {
                System.out.println("Прошло секунд с начала: " + ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) +
                        " future done? " + future.isDone());
                // Выводим в консоль полученное значение
                System.out.println("имя потока: " + future.get());
                System.out.println("Прошло секунд с начала: " + ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) +
                        " future done? " + future.isDone() + "\n");
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }
        // Останавливаем пул потоков
        executor.shutdown();
        System.out.println(LocalDateTime.now());


        /*// Вместо следующего кода
        new Thread(() -> System.out.println(Thread.currentThread().getName() +
                " - Побочный поток с использованием класса Thread.")).start();

        // можно использовать
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(() -> System.out.println(Thread.currentThread().getName() +
                " - Побочный поток с использованием ExecutorService."));*/
    }

}
