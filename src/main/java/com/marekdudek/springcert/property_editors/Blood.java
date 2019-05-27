package com.marekdudek.springcert.property_editors;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public final class Blood
{
    public final BloodType type;
    public final RhFactor rh;
}
