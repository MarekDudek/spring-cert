package com.marekdudek.springcert.methods;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MethodLookupTest
{
    @Autowired
    private DemoBean demoBean;

    @RepeatedTest(10)
    void test(final RepetitionInfo info)
    {
        // when
        demoBean.doSomething();
        // then

        assertThat(LookupDemoBean.InstancesCount).isEqualTo(1);
        assertThat(Singer.InstancesCount).isEqualTo(info.getCurrentRepetition());
    }
}
