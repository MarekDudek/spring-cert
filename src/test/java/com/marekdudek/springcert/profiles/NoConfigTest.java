package com.marekdudek.springcert.profiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class NoConfigTest
{
    @Autowired
    private ConfigurableApplicationContext ctx;
    private AssertableApplicationContext context;

    @PostConstruct
    void init()
    {
        context = AssertableApplicationContext.get(() -> ctx);
    }


    @Test
    void test()
    {
        assertThat(context).doesNotHaveBean(ComponentA.class);
        assertThat(context).doesNotHaveBean(ComponentB.class);
    }
}
