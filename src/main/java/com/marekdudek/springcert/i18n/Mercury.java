package com.marekdudek.springcert.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import static java.util.Locale.JAPAN;

@Component
final class Mercury implements MessageSourceAware
{
    private MessageSource messageSource;

    @Override
    public void setMessageSource(final MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    String message()
    {
        return messageSource.getMessage("message", new Object[]{}, JAPAN);
    }
}
