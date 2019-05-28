package com.marekdudek.springcert.properties;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
final class LocalDateCustomPropertyEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(final String text)
    {
        final LocalDate date = LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
        setValue(date);
    }
}
