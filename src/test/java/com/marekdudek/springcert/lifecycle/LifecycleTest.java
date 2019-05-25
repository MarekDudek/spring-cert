package com.marekdudek.springcert.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LifecycleTest
{
    @Autowired
    private Cycling cycling;


    @Test
    void test()
    {
        assertThat(cycling.name).isEqualTo("cycling");
    }
}
