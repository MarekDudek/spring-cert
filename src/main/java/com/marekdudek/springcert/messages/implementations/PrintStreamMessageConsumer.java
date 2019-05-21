package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

import static lombok.AccessLevel.PUBLIC;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Builder
@FieldDefaults(level = PUBLIC, makeFinal = true)
public final class PrintStreamMessageConsumer implements MessageConsumer
{
    @NonNull
    PrintStream printStream;

    @Override
    public void render(final String message)
    {
        printStream.println(message);
    }
}
