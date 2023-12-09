package com.example.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@Slf4j
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

    @SneakyThrows
    @Around("com.example.aop.Pointcuts.onAnyMethod()")
    public Object onAnyMethod(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        List<String> args = Arrays.stream(joinPoint.getArgs()).map(Object::toString).toList();

        LogInfo logInfo = new LogInfo(className, methodName, args);

        log.info(">>>Aspect: Class: " + logInfo.className
                + ", method: " + logInfo.methodName
                + ", args: " + args);

        return joinPoint.proceed();
    }

    record LogInfo(String className, String methodName, List<String> args) {
    }
}
