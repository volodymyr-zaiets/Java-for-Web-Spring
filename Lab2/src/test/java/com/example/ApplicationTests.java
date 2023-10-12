package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    void test1() {
        Person myPerson = context.getBean("person", Person.class);
        System.out.println("---------- Time Skip ----------");
        myPerson.checkGlass();
        myPerson.setGlass(new Tumbler(new Vine()));
        System.out.println("---------- Time Skip ----------");
        myPerson.fall();
    }
}
