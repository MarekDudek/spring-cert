package com.marekdudek.springcert.i18n;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

import static com.google.common.base.Charsets.UTF_8;

@SpringBootConfiguration
class I18nConfig
{
    private static final String[] BASE_NAMES =
            new String[]{
                    "format",
                    "exceptions"
            };

    @Bean
    ResourceBundleMessageSource messageSource()
    {
        final ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames(BASE_NAMES);
        source.setDefaultEncoding(UTF_8.name());
        return source;
    }

    @Bean
    Locale locale()
    {
        return Locale.forLanguageTag("pl");
    }
}
