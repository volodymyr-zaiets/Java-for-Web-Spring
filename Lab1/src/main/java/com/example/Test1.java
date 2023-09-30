package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
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

