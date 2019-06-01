package com.donghun.pt8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Demo32Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo32Application.class);
    }
}