package com.donghun.pt5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {

    @Bean
    public StudentRepository studentRepository() {
        return new TestStudentRepository();
    }
}
