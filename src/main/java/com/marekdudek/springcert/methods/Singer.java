package com.marekdudek.springcert.methods;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component
@Scope("prototype")
class Singer
{
    static int InstancesCount = 0;

    final int number = ++InstancesCount;

    void sing()
    {
        out.println("singer " + number);
    }
}
