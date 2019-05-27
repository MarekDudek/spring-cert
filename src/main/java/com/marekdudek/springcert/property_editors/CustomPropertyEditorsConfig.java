package com.marekdudek.springcert.property_editors;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyEditor;
import java.time.LocalDate;

@SpringBootConfiguration
@ComponentScan
@PropertySource({"classpath:/blood.properties", "classpath:/complex.properties"})
class CustomPropertyEditorsConfig
{
    @Bean
    Blood blood
            (
                    @Value("${blood.type}") final BloodType type,
                    @Value("${blood.rh}") final RhFactor rh
            )
    {
        return Blood.builder().
                type(type).
                rh(rh).
                build();
    }

    @Bean
    ComplexBean complexBean
            (
                    @Value("${complex.class}") final Class clazz,
                    @Value("${complex.date}") final LocalDate date
            )
    {
        return ComplexBean.builder().
                clazz(clazz).
                date(date).
                build();
    }

    private static final ImmutableMap<Class<?>, Class<? extends PropertyEditor>> EDITORS =
            ImmutableMap.of(
                    LocalDate.class, LocalDateCustomPropertyEditor.class
            );

    @Bean
    static CustomEditorConfigurer configurer()
    {
        final CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        configurer.setCustomEditors(EDITORS);
        return configurer;
    }
}
