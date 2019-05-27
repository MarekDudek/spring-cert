package com.marekdudek.springcert.property_editors;

import lombok.Data;

@Data
public class Blood
{
    public final BloodType type;
    public final RhFactor rh;
}
