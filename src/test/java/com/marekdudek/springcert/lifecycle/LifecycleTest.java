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
    void bean_name_properly_set()
    {
        assertThat(cycling.name).isEqualTo("cycling");
    }

    @Test
    void dependent_bean_set_on_dependency()
    {
        cycling.wheel.setCycling(cycling); // TODO: lack of it is not detected by test
    }
}
