package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println(test());
    }

    public static String test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Person myPerson = context.getBean("person", Person.class);
        System.out.println("---------- Time Skip ----------");
        myPerson.checkGlass();
        myPerson.setGlass(new Tumbler(new Vine()));
        System.out.println("---------- Time Skip ----------");
        myPerson.fall();

        context.close();

        return "Test complete!";
    }
}
