package com.marekdudek.springcert.aspects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
final class AspectsTest
{
    @Autowired
    private SomeComponent component;

    @Test
    void test()
    {
        component.method1();
    }
}
