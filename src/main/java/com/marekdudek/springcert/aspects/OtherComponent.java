package com.marekdudek.springcert.aspects;

import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component
@SomeAnnotation
class OtherComponent
{
    @SomeAnnotation
    void method()
    {
        out.println("other-component.method");
    }

    @SomeAnnotation
    int printAndGetLength(final String string)
    {
        out.println(string);
        return string.length();
    }
}
