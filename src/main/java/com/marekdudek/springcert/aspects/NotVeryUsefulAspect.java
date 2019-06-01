package com.marekdudek.springcert.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Aspect
@Component
final class NotVeryUsefulAspect
{
    @Pointcut("execution(* method*(..))")
    public void somePointcut()
    {
    }

    @Before("somePointcut()")
    public void beforeSomePointcut()
    {
        out.println("before");
    }

    @After("somePointcut()")
    public void afterSomePointcut()
    {
        out.println("after");
    }
}
