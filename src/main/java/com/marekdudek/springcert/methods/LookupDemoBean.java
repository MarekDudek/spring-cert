package com.marekdudek.springcert.methods;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component
public class LookupDemoBean implements DemoBean
{
    static int InstancesCount = 0;

    private int number = ++InstancesCount;

    @Override
    @Lookup
    public Singer supplier()
    {
        return null;
    }

    @Override
    public void doSomething()
    {
        out.println("demo " + number);
        final Singer singer = supplier();
        singer.sing();
    }
}
