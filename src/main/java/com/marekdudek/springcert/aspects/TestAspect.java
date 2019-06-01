package com.marekdudek.springcert.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Aspect
@Component
final class TestAspect
{
    @Pointcut("execution(* *(..))")
    void everyMethod()
    {
    }

    @Pointcut("within(com.marekdudek.springcert.aspects.*)")
    void aspectsPackage()
    {
    }

    @Before("everyMethod() && aspectsPackage()")
    void beforeEveryMethod()
    {
        out.println("before");
    }

    @After("everyMethod() && aspectsPackage()")
    void afterEveryMethod()
    {
        out.println("after");
    }
}
