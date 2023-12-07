package com.example.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.example.Glass.broke())")
    public void onGlassBroke() {
    }

    @Pointcut("execution(* com.example.Liquid.flow())")
    public void onLiquidFlow() {
    }

    @Pointcut("execution(* com.example.Person.fall())")
    public void onPersonFall() {
    }

    @Pointcut("execution(* com.example.Liquid.*(..))")
    public void onAnyLiquidMethod() {
    }

    @Pointcut("execution(* com.example.*.*(..))")
    public void onAnyMethod() {
    }
}
