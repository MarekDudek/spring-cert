package com.marekdudek.springcert.property_editors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class PropertyEditorsTest
{
  /*  @Autowired
    private Blood blood;*/

    @Autowired
    private ComplexBean complexBean;

    @Test
    void test()
    {
        assertThat(complexBean.getClazz()).isEqualTo(String.class);
    }
}
