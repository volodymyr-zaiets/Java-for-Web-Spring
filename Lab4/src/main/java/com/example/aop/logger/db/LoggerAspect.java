package com.example.aop.logger.db;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @SneakyThrows
    @Around("com.example.aop.Pointcuts.onServiceMethod()")
    public Object onServiceMethod(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        List<String> args = Arrays.stream(joinPoint.getArgs()).map(Object::toString).toList();

        LogInfo logInfo = new LogInfo(className, methodName, args);

        log.info("Service: Class: " + logInfo.className
                + ", method: " + logInfo.methodName
                + ", args: " + args);

        return joinPoint.proceed();
    }

    @SneakyThrows
    @Around("com.example.aop.Pointcuts.onRepositoryMethod()")
    public Object onRepositoryMethod(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        List<String> args = Arrays.stream(joinPoint.getArgs()).map(Object::toString).toList();

        LogInfo logInfo = new LogInfo(className, methodName, args);

        log.info("Repository: Class: " + logInfo.className
                + ", method: " + logInfo.methodName
                + ", args: " + args);

        return joinPoint.proceed();
    }

    record LogInfo(String className, String methodName, List<String> args) {
    }
}
