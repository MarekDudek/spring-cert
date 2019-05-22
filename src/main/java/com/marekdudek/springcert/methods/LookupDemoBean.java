package com.marekdudek.springcert.methods;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class LookupDemoBean implements DemoBean
{
    private static int COUNT = 0;

    final int number = ++COUNT;

    @Override
    @Lookup
    public Singer supplier()
    {
        return null;
    }

    @Override
    public int doSomething()
    {
        final Singer singer = supplier();
        return singer.number;
    }
}
