package com.marekdudek.springcert.property_editors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.marekdudek.springcert.property_editors.BloodType.AB;
import static com.marekdudek.springcert.property_editors.RhFactor.Rh_Plus;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class PropertyEditorsTest
{
    @Autowired
    private ComplexBean complexBean;

    @Autowired
    private Blood blood;

    @Test
    void complex_bean()
    {
        assertThat(complexBean.getClazz()).isEqualTo(String.class);
    }

    @Test
    void blood()
    {
        final Blood expected =
                Blood.builder().
                        type(AB).
                        rh(Rh_Plus).build();
        assertThat(blood).isEqualTo(
                expected
        );
    }
}
