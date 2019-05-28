package com.marekdudek.springcert.properties;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public final class Blood
{
    public final BloodType type;
    public final RhFactor rh;
}
