package com.marekdudek.springcert.methods;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class MethodLookupTest
{
    @Autowired
    private DemoBean demoBean;

    @Test
    void test()
    {
        IntStream.range(1, 10).
                forEach(i ->
                        demoBean.doSomething()
                );
    }
}
