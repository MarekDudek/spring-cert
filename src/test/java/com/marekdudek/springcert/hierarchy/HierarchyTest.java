package com.marekdudek.springcert.hierarchy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

final class HierarchyTest
{
    @Test
    void config_one()
    {
        // given
        final ApplicationContext context = new AnnotationConfigApplicationContext(ConfigOne.class);
        // when
        final String one = context.getBean("one", String.class);
        // then
        assertThat(one).isEqualTo("alpha");
        // when
        final Throwable error = catchThrowable(() -> context.getBean(String.class));
        // then
        assertThat(error).isInstanceOf(NoUniqueBeanDefinitionException.class);
    }

    @Test
    void bean_definition_is_overridden_by_child_context()
    {
        // given
        final GenericApplicationContext ctx1 = new AnnotationConfigApplicationContext(ConfigOne.class);
        final GenericApplicationContext ctx2 = new AnnotationConfigApplicationContext(ConfigTwo.class);
        ctx2.setParent(ctx1);
        // when
        final String one = ctx2.getBean("one", String.class);
        // then
        assertThat(one).isEqualTo("gamma");
        // when
        final String two = ctx2.getBean("two", String.class);
        // then
        assertThat(two).isEqualTo("beta");
    }
}
