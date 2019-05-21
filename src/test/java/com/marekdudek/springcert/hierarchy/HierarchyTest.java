package com.marekdudek.springcert.hierarchy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        final String string = context.getBean("one", String.class);
        // then
        assertThat(string).isEqualTo("alpha");
        // when
        final Throwable error = catchThrowable(() -> context.getBean(String.class));
        // then
        assertThat(error).isInstanceOf(NoUniqueBeanDefinitionException.class);
    }

    @Test
    void config_one_is_parent_of_config_two()
    {
        // given
        final AnnotationConfigApplicationContext ctx1 = new AnnotationConfigApplicationContext();
        ctx1.register(ConfigOne.class);
        ctx1.refresh();
        final AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
        ctx2.register(ConfigTwo.class);
        ctx2.setParent(ctx1);
        ctx2.refresh();
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
