package com.example;

public class Person {
    Glass glass;
    String scream;

    public Person() {
        System.out.println("There is person");
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
}

