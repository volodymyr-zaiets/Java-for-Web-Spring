package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("person")
//@Scope("singleton")
public class Person {
    Glass glass;
    @Value("${person.scream}")
    String scream;

//    @Autowired
    public Person(Glass glass) {
        System.out.println("There is person with " + glass.getClass().getSimpleName());
        this.glass = glass;
    }

    public void setGlass(Glass glass) {
        System.out.println("People took a " + glass.getClass().getSimpleName()
                + " filled with " + glass.getLiquid().getClass().getSimpleName());
        this.glass = glass;
    }

    public Glass getGlass(Glass glass) {
        return glass;
    }

    public void setScream(String scream) {
        this.scream = scream;
    }

    public String getScream(String scream) {
        return scream;
    }

    public void checkGlass() {
        System.out.println("People holding a " + glass.getClass().getSimpleName()
                + " filled with " + glass.getLiquid().getClass().getSimpleName());
    }

    public void fall() {
        System.out.println("People falls");
        glass.broke();
        System.out.println("People screams: \"" + scream + "\"");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Person: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Person: destroy method");
    }
}

