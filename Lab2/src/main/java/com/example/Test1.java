package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Person myPerson = context.getBean("person", Person.class);
        System.out.println("---------- Time Skip ----------");
        myPerson.checkGlass();
        myPerson.setGlass(new Tumbler(new Vine()));
        System.out.println("---------- Time Skip ----------");
        myPerson.fall();

        context.close();
    }
}
