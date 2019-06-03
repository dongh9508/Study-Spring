package com.donghun.envirornment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class Deno123Application {

    public static void main(String[] args) {
        SpringApplication.run(Deno123Application.class);
    }
}
