package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class ApplicationTests {

    @Test
    void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Person myPerson = context.getBean("myPerson", Person.class);
        System.out.println("---------- Time Skip ----------");
        myPerson.checkGlass();
        myPerson.setGlass(new Tumbler(new Vine()));
        System.out.println("---------- Time Skip ----------");
        myPerson.fall();

        context.close();
    }

}
