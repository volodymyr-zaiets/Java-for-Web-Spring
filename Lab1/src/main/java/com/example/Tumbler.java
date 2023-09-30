package com.example;

public class Tumbler implements Glass {
    Liquid liquid;

    public Tumbler() {
        System.out.println("There is tumbler");
    }

    public Tumbler(Liquid liquid) {
        System.out.println("There is tumbler with " + liquid.getClass().getSimpleName());
        this.liquid = liquid;
    }

    public void setLiquid(Liquid liquid) {
        System.out.println("Liquid on tumbler is changed on " + liquid.getClass().getSimpleName());
        this.liquid = liquid;
    }

    public Liquid getLiquid() {
        return liquid;
    }

    public void checkLiquid() {
        System.out.println("Tumbler is filled with " + liquid.getClass().getSimpleName());
    }

    public void broke() {
        System.out.println("Tumbler is broken");
        liquid.flow();
    }
}
