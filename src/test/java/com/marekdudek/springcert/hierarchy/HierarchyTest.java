package com.marekdudek.springcert.hierarchy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

final class HierarchyTest
{
    @Test
    void test()
    {
        // when
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigOne.class);
        // then
        final String string = ctx.getBean("stringOne", String.class);
        assertThat(string).isEqualTo("one");
    }
}
