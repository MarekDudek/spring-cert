package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PUBLIC;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Builder
@FieldDefaults(level = PUBLIC, makeFinal = true)
public final class ConstMessageSupplier implements MessageSupplier
{
    @NonNull
    String message;

    @Override
    public String message()
    {
        return message;
    }
}
