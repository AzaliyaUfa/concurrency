package ru.ibs.concur.executor;

import java.util.concurrent.Callable;

public class CallableClass implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return Thread.currentThread().getName();
    }
}
