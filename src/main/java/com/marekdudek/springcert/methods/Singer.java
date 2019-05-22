package com.marekdudek.springcert.methods;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
class Singer
{
    private static int COUNT = 0;

    final int number = ++COUNT;
}
