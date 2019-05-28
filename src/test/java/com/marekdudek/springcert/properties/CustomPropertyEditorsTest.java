package com.marekdudek.springcert.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.marekdudek.springcert.properties.BloodType.AB;
import static com.marekdudek.springcert.properties.RhFactor.Rh_Plus;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class CustomPropertyEditorsTest
{
    @Autowired
    private ComplexBean complexBean;

    @Autowired
    private Blood blood;

    @Test
    void complex_bean()
    {
        assertThat(complexBean.clazz).isEqualTo(String.class);
        assertThat(complexBean.date).isEqualTo(LocalDate.of(2019, 05, 23));
    }

    @Test
    void blood()
    {
        final Blood expected =
                Blood.builder().
                        type(AB).
                        rh(Rh_Plus).build();
        assertThat(blood).isEqualTo(expected);
    }
}
