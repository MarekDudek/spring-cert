package com.marekdudek.springcert.lifecycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LifecycleTest
{
    @Autowired
    private Cycling cycling;

    @BeforeEach
    void setUp()
    {
        cycling.wheel.setCycling(cycling); // TODO: lack of it is not detected by test
    }


    @Test
    void bean_can_be_manually_finalized(@Autowired final DefaultListableBeanFactory beanFactory)
    {
        // when
        beanFactory.destroySingletons();
        // then
        assertThat(cycling.preDestroyed).isTrue();
        assertThat(cycling.destroyed).isTrue();
        assertThat(cycling.stopped).isTrue();
        // FIXME: this can break when tests are executed in different order
    }

    @Test
    void during_test_bean_is_initialized_and_not_finalized()
    {
        assertThat(cycling.name).isEqualTo("cycling");

        assertThat(cycling.constructed).isTrue();
        assertThat(cycling.propertiesSet).isTrue();
        assertThat(cycling.started).isTrue();

        assertThat(cycling.preDestroyed).isFalse();
        assertThat(cycling.destroyed).isFalse();
        assertThat(cycling.stopped).isFalse();
    }
}
