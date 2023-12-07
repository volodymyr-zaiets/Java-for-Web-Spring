package com.example;

import org.springframework.stereotype.Component;

//@Component("vine")
public class Vine implements Liquid {

    public Vine() {
        System.out.println("There is vine");
    }

    public void flow() {
        System.out.println("Vine flows");
    }
}
