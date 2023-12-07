package com.example;

import org.springframework.stereotype.Component;

//@Component("water")
public class Water implements Liquid {

    public Water() {
        System.out.println("There is water");
    }

    public void flow() {
        System.out.println("Water flows");
    }
}
