package com.marekdudek.springcert.aspects;

import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component
class OtherComponent
{
    void method()
    {
        out.println("other-component.method");
    }

    int stringParameter(final String parameter)
    {
        out.println(parameter);
        return parameter.length();
    }
}
