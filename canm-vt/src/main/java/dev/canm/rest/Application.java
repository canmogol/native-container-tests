package dev.canm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    String hello() {
        log.info("{} Thread: {}, {}", Thread.currentThread().isVirtual() ? "Virtual" : "Platform", Thread.currentThread().threadId(), Thread.currentThread().getName());
        return "Hello World!";
    }

}
