package com.donghun.pt3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

    @Autowired
    List<BookRepository> bookRepositories;

//    @Autowired @Qualifier("donghunBookRepository")
//    BookRepository bookRepository;

//    @Autowired
//    BookRepository bookRepository;

//    public void printBookRepository() {
////        System.out.println(bookRepository.getClass());
//        this.bookRepositories.forEach(System.out::println);
//    }


    @PostConstruct // 이 단계에서는 @Autowired로 주입받는 빈들이 다 주입 받았다고 가정하고 진행됨. Runner 없이도 진행된다.
    // Runner의 경우는 애플리케이션이 다 구동됬을 때, 동작하는것인데, @PostConstruct가 붙은 밑의 메소드의 경우, 애플리케이션 구동중에 작동된다.
    // 그래서 Runner와 찍히는 위치가 다르다. Runnser는 맨 마지막에 찍히고, 밑의 경우는 중간에 찍힌다.
    public void setup() {
//        System.out.println(bookRepository.getClass());
        this.bookRepositories.forEach(System.out::println);
    }


}
