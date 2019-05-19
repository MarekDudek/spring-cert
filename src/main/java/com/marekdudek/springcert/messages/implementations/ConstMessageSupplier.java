package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;

@Builder
@AllArgsConstructor
public final class ConstMessageSupplier implements MessageSupplier
{
    @NonNull
    public final String message;

    @Override
    public String message()
    {
        return message;
    }
}
