package com.donghun.pt2;


import com.donghun.pt1.PhoneRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void GetBeans() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
    }

    @Test
    public void BeansNullTest() {
        PersonService personService = (PersonService) context.getBean("personService");
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        assertThat(personService).isNotNull();
        assertThat(personRepository).isNotNull();
    }
}