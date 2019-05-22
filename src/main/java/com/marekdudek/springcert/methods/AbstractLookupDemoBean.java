package com.marekdudek.springcert.methods;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractLookupDemoBean implements DemoBean
{
    @Override
    @Lookup
    public Singer getSinger()
    {
        return null;
    }

    @Override
    public void doSomething()
    {
        final Singer singer = getSinger();
        singer.sing();
    }
}
