package com.marekdudek.springcert.methods;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
class Utilizer
{
    private static int COUNT = 0;

    final int number = ++COUNT;

    @Lookup
    Product supplier()
    {
        return null;
    }
}
