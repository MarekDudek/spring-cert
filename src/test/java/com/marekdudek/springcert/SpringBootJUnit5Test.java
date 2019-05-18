package com.marekdudek.springcert;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class SpringBootJUnit5Test
{
    @Test
    void test(final ApplicationContext context)
    {
        assertThat(context).isNotNull();
        final String name = context.getApplicationName();
        assertThat(name).isEmpty();
    }
}
