package com.donghun;

import com.donghun.book.BookRepository;
import com.donghun.book.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
        BookService bookService = (BookService) context.getBean("bookService");
        BookRepository bookRepository = context.getBean(BookRepository.class);
        System.out.println(bookService != null);
        System.out.println(bookRepository != null);
    }

}
