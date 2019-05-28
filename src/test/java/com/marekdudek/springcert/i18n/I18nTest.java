package com.marekdudek.springcert.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static java.util.Locale.CHINESE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class I18nTest
{
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Locale locale;

    @Test
    void localized_message()
    {
        // when
        final String message = messageSource.getMessage("message", new Object[]{}, locale);
        // then
        assertThat(message).isEqualTo("Aligatory rządzą!");
    }

    @Test
    void message_with_replacement_values()
    {
        // when
        final String message = messageSource.getMessage("argument.required", new Object[]{"heated"}, CHINESE);
        // then
        assertThat(message).isEqualTo("The heated argument is required.");
    }
}
