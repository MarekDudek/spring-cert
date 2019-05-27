package com.marekdudek.springcert.property_editors;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Component
final class LocalDateCustomPropertyEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(final String text) throws IllegalArgumentException
    {
        final LocalDate date = LocalDate.of(1976, 10, 13);
        setValue(date);
    }
}
