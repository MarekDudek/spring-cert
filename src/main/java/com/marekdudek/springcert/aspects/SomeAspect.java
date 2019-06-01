package com.marekdudek.springcert.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Aspect
@Component
final class SomeAspect
{
    @Pointcut("execution(* *(..))")
    void everyMethod()
    {
    }

    @Pointcut("within(com.marekdudek.springcert.aspects.*)")
    void aspectsPackage()
    {
    }

    @Pointcut("this(SomeComponent)")
    void someComponentBeanReference()
    {
    }

    @Pointcut("target(SomeComponent)")
    void someComponentTargetObject()
    {
    }

    @Pointcut("args(String)")
    void stringOrVoid()
    {
    }

    @Before("everyMethod() && aspectsPackage() && someComponentBeanReference() && someComponentTargetObject()")
    void beforeEveryMethod()
    {
        out.println("before");
    }

    @After("everyMethod() && aspectsPackage() && someComponentBeanReference() && someComponentTargetObject()")
    void afterEveryMethod()
    {
        out.println("after");
    }

    @Around("stringOrVoid() && aspectsPackage()")
    Object aroundStringOrVoid(final ProceedingJoinPoint joinPoint) throws Throwable
    {
        out.println("pre");
        final Object value = joinPoint.proceed();
        out.println("post");
        return value;
    }
}
