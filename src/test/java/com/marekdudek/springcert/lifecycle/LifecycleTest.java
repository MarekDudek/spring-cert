package com.marekdudek.springcert.lifecycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class LifecycleTest
{
    @Autowired
    private Cycling cycling;


    @Autowired
    DefaultListableBeanFactory beanFactory;


    @BeforeEach
    void setUp()
    {
        cycling.wheel.setCycling(cycling); // TODO: lack of it is not detected by test
    }

    @Test
    void bean_can_be_manually_finalized()
    {
        // when
        beanFactory.destroySingletons();
        // then
        assertIsFinalized(cycling);
        // FIXME: this can break when tests are executed in different order
        // when
        final Cycling bean = beanFactory.getBean(Cycling.class);
        // then
        bean.wheel.setCycling(bean);
        assertIsInitialized(bean);
        assertIsNotFinalized(bean);
    }

    @Test
    void during_test_bean_is_initialized_and_not_finalized()
    {
        // then
        assertIsInitialized(cycling);
        assertIsNotFinalized(cycling);
    }

    private static void assertIsInitialized(final Cycling cycling)
    {
        assertThat(cycling.constructed).isTrue();
        assertThat(cycling.propertiesSet).isTrue();
        assertThat(cycling.started).isTrue();
    }

    private static void assertIsNotFinalized(final Cycling cycling)
    {
        assertThat(cycling.preDestroyed).isFalse();
        assertThat(cycling.destroyed).isFalse();
        assertThat(cycling.stopped).isFalse();
    }

    private static void assertIsFinalized(final Cycling cycling)
    {
        assertThat(cycling.preDestroyed).isTrue();
        assertThat(cycling.destroyed).isTrue();
        assertThat(cycling.stopped).isTrue();
    }
}
