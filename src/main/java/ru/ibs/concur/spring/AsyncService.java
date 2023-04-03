package ru.ibs.concur.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Future;

@Service
@Slf4j
public class AsyncService {

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithVoidReturnType() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Execute method asynchronously: "
                + Thread.currentThread().getName() + " time: " + LocalDateTime.now());
    }

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithErr() throws Exception {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(new Random().nextBoolean()) {
           throw new Exception("custom exception");
        }
        log.info("Execute method asynchronously: "
                + Thread.currentThread().getName() + " time: " + LocalDateTime.now());
    }

    @Async("threadPoolTaskExecutor")
    public Future<String> asyncMethodWithReturnType() {
        log.info("Execute method asynchronously - "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<>("hello world !!!!");
        } catch (InterruptedException e) {
            //
        }
        return null;
    }

}

