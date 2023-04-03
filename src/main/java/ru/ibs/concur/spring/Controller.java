package ru.ibs.concur.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class Controller {

    private final AsyncService asyncService;

    public Controller(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("async")
    public void executeAsync ()  {
        for(int i = 0; i < 5; i++) {
            asyncService.asyncMethodWithVoidReturnType();
        }
    }

    @GetMapping("err")
    public void executeAsyncWithError () throws Exception {
        for(int i = 0; i < 5; i++) {
            asyncService.asyncMethodWithErr();
        }
    }
}
