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
    Object upperCaseAndDoubleLength(final ProceedingJoinPoint joinPoint) throws Throwable
    {
        final Object[] args = joinPoint.getArgs();
        final String param = (String) args[0];
        final Object[] changed = new Object[]{param.toUpperCase()};

        out.println(" pre ");

        final Object result = joinPoint.proceed(changed);

        out.println(" post ");

        final int length = (int) result;

        return 2 * length;
    }
}
