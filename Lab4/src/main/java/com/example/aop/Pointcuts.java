package com.example.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.repository.*.*(..))")
    public void onRepositoryMethod() {
    }

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void onServiceMethod() {
    }
}
