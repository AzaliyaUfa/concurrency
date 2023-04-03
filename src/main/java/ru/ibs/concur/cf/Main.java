package ru.ibs.concur.cf;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": - Главный поток начался.");
        //LocalDateTime startTime = LocalDateTime.now();

        /**
         * Обработка исключений с использованием метода handle()
         */

        Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
            if (age > 18) {
                return "Взрослый";
            } else {
                return "Ребёнок";
            }
        }).thenApply(res -> {
            return "Зрелость: " + res;
        })
                .handle((res, ex) -> {
                    if (ex != null) {
                        System.out.println("Ой! У нас тут исключение - " + ex.getMessage());
                        return "Неизвестно!";
                    }
                    return res;
                });

        System.out.println(maturityFuture.get());



        /**
         * Обработка исключений с использованием метода exceptionally()
         */

        /*Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
            if (age > 18) {
                return "Взрослый";
            } else {
                return "Ребёнок";
            }
        }).thenApply(res -> {
            return "Зрелость: " + res;
        })
                .exceptionally(ex -> {
            System.out.println("Ой! У нас тут исключение - " + ex.getMessage());
            return "Неизвестно!";
        });

        System.out.println(maturityFuture.get());*/


        /**
         * Пример anyOf()
         */

/*        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 1;
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Результат Future 2";
        });

        CompletableFuture<Boolean> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return true;
        });

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);

        System.out.println(anyOfFuture.get()); // Результат Future 2*/

        /**
         * Пример allOf()
         */

/*        // Асинхронно загружаем содержимое всех веб-страниц
        List<CompletableFuture<String>> pageContentFutures = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            pageContentFutures.add(downloadWebPage("link" + i));
        }

        // Создаём комбинированный Future, используя allOf()
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                pageContentFutures.toArray(new CompletableFuture[0])
        );

        // Когда все задачи завершены, вызываем future.join(),
        // чтобы получить результаты и собрать их в список
        CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
            return pageContentFutures.stream()
                    .map(pageContentFuture -> pageContentFuture.join())
                    .collect(Collectors.toList());
        });

        // Подсчитываем количество веб-страниц, содержащих ключевое слово "surprise"
        CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
            return pageContents.stream()
                    .filter(pageContent -> pageContent.contains("surprise"))
                    .count();
        });

        System.out.println("Количество веб-страниц с ключевым словом surprise = " +
                countFuture.get());*/

        /**
         * Пример thenCombine
         */
        /*CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Получен вес.");
            return 65.0;
        });

        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Получен рост.");
            return 177.8;
        });

        CompletableFuture<Double> combinedFuture = weightInKgFuture
                .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
                    System.out.println("Начат расчёт индекса массы тела.");
                    Double heightInMeter = heightInCm / 100;
                    return weightInKg / (heightInMeter * heightInMeter);
                });

        System.out.println("Ваш индекс массы тела = " + combinedFuture.get());*/


        /**
         * Пример thenCompose
         */
        /*CompletableFuture<CompletableFuture<Double>> cf = getUserDetail("userId")
                .thenApply(user -> getCreditRating(user));

        Double result = cf.get().get();*/
        /*CompletableFuture<Double> cf = getUserDetail("userId")
                .thenCompose(user -> getCreditRating(user));
        Double result = cf.get();
        System.out.println(Thread.currentThread().getName() + ": result = " + result);*/


        /**
         * Создаём CompletableFuture
         */
       /* CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println(Thread.currentThread().getName() + " supplyAsync генерирует имя пользователя");
            return "someUserName";
        });*/

        /**
         * пример thenApply
         */
        /*// Добавляем callback к Future, используя thenApply()
        CompletableFuture<String> greetingFuture = cf.thenApply(name -> {
            System.out.println(Thread.currentThread().getName() + " thenApply добавляет приветствие");
            return "Привет," + name;
        })
                .thenApply(greeting -> {
                    System.out.println(Thread.currentThread().getName() + " thenApply добавляет пожелание");
                    return greeting + ", добро пожаловать!";
                });
        // Проверка, что thenApply() не блокирует код
        System.out.println(Thread.currentThread().getName() + " продолжает работу после запуска метода thenApply");

        // Блокировка и получение результата Future
        System.out.println(Thread.currentThread().getName() + " выводит результат метода get: " + greetingFuture.get());*/

        /**
         * пример thenAccept
         */
        /*CompletableFuture<Void> greetingFuture2 = cf.thenAccept(name -> {
            System.out.println(Thread.currentThread().getName() + " thenAccept добавляет приветствие:");
            System.out.println(Thread.currentThread().getName() + " Привет," + name);
        }).
                thenAccept(greeting -> {
                    System.out.println(Thread.currentThread().getName() + " thenAccept добавляет пожелание:");
                    System.out.println(Thread.currentThread().getName() + " " + greeting + ", добро пожаловать!");
                });

        // Проверка, что thenAccept() не блокирует код
        System.out.println(Thread.currentThread().getName() + " продолжает работу после запуска метода thenAccept");

        // Блокировка и получение результата Future
        greetingFuture2.get();*/

        /**
         * пример thenRun
         */
        /*CompletableFuture<Void> greetingFuture3 = cf.thenRun(() -> {
            System.out.println(Thread.currentThread().getName() + " thenRun выполняет какие-то действия");
        })
                .thenRun(() -> System.out.println(Thread.currentThread().getName() +
                        " thenRun выполняет другие действия"));

        // Проверка, что thenRun() не блокирует код
        System.out.println(Thread.currentThread().getName() + " продолжает работу после запуска метода thenRun");

        // Блокировка и получение результата Future
        greetingFuture3.get();*/

        /**
         * пример thenApplyAsync
         */
        /*CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": метод supplyAsync");
            return 1;
        })
                .thenApplyAsync(res -> {
                    // Выполняется в другом потоке, взятом из ForkJoinPool.commonPool()
                    System.out.println(Thread.currentThread().getName() + ": метод thenApplyAsync1");
                    return ++res;
                })
                .thenApplyAsync(res -> {
                    // Выполняется в другом потоке, взятом из ForkJoinPool.commonPool()
                    System.out.println(Thread.currentThread().getName() + ": метод thenApplyAsync2");
                    return ++res;
                });
        System.out.println(Thread.currentThread().getName() + ": result = " + result.get());*/

        /**
         * простейший пример создания экземпляра CompletableFuture
         */
        /*CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Результат задачи 1");
        String result1 = completableFuture.get();
        System.out.println(result1);
        completableFuture.complete("Результат задачи 2");
        String result2 = completableFuture.get();
        System.out.println(result2);*/
        /**
         * пример runAsync
         */
        /*CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                // Имитация длительной работы
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println(threadName + ": Действия в побочном потоке");
            }
        });*/
        /**
         * пример supplyAsync
         */
        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                String threadName = Thread.currentThread().getName();
                // Имитация длительной работы
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                return threadName;
            }
        });
        System.out.println(threadName + ": Действия в главном потоке");
        System.out.println(threadName + getTimeMsg(startTime));
        System.out.println("Запускаем метод get");
        // Блокировка и получение результата Future
        String result = future.get();
        System.out.println("Метод get завершён с результатом: " + result);
        System.out.println(threadName + getTimeMsg(startTime));*/

        //System.out.println(threadName + ": - Главный поток закончился.");
    }

    private static CompletableFuture<String> getUserDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            // имитируем работу стороннего сервиса UserService.getUserDetails(userId);
            System.out.println(Thread.currentThread().getName() + ": имитируем работу стороннего сервиса UserService");
            return "User";
        });
    }

    private static CompletableFuture<Double> getCreditRating(String user) {
        return CompletableFuture.supplyAsync(() -> {
            // имитируем работу стороннего сервиса CreditRatingService.getCreditRating(user);
            System.out.println(Thread.currentThread().getName() + ": имитируем работу стороннего сервиса CreditRatingService");
            return 5.00;
        });
    }

    private static CompletableFuture<String> downloadWebPage(String pageLink) {
        return CompletableFuture.supplyAsync(() -> {
            // Код загрузки и возврата содержимого веб-страницы
            Random rd = new Random();
            return rd.nextBoolean() ? "page content of " + pageLink :
                    "surprise page content of " + pageLink;
        });
    }

    private static String getTimeMsg(LocalDateTime startTime) {
        return ": Прошло секунд с начала: " + ChronoUnit.SECONDS.between(startTime, LocalDateTime.now());
    }
}
