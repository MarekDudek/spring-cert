package com.marekdudek.springcert.property_editors;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@EqualsAndHashCode
@ToString
final class ComplexBean
{
    @NonNull
    public final Class clazz;

    @NonNull
    public final LocalDate date;
}
