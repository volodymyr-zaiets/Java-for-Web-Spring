package com.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

    @Before("com.example.aop.Pointcuts.onGlassBroke()")
    public void onGlassBroke() {
        System.out.println(">>>Aspect: onGlassBroke()");
    }

    @Before("com.example.aop.Pointcuts.onLiquidFlow()")
    public void onLiquidFlow() {
        System.out.println(">>>Aspect: onLiquidFlow()");
    }

    @Before("com.example.aop.Pointcuts.onPersonFall()")
    public void onPersonFall() {
        System.out.println(">>>Aspect: onPersonFall()");
    }

    @Before("com.example.aop.Pointcuts.onAnyLiquidMethod()")
    public void onAnyLiquidMethod() {
        System.out.println(">>>Aspect: onAnyLiquidMethod()");
    }

    @Before("com.example.aop.Pointcuts.onAnyMethod()")
    public void onAnyMethod() {
        System.out.println(">>>Aspect: onAnyMethod()");
    }
}
