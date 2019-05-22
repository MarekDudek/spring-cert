package com.marekdudek.springcert.methods;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class LookupDemoBean
{
    private static int COUNT = 0;

    final int number = ++COUNT;

    @Lookup
    Singer supplier()
    {
        return null;
    }

    int doSomething()
    {
        final Singer singer = supplier();
        return singer.number;
    }
}
