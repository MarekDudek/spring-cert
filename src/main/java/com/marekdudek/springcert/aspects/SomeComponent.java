package com.marekdudek.springcert.aspects;

import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component
class SomeComponent
{
    void method1()
    {
        out.println("method 1 executing");
    }
}
