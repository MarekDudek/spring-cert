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
    private LookupDemoBean demoBean;

    @RepeatedTest(10)
    void test(final RepetitionInfo info)
    {
        // when
        final int singerNumber = demoBean.doSomething();
        // then
        assertThat(singerNumber).isEqualTo(info.getCurrentRepetition());
        assertThat(demoBean.number).isEqualTo(1);
    }
}
