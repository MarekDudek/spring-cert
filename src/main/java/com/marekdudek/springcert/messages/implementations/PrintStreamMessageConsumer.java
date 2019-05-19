package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;

import java.io.PrintStream;

@Builder
@AllArgsConstructor
public final class PrintStreamMessageConsumer implements MessageConsumer
{
    @NonNull
    public final PrintStream printStream;

    @Override
    public void render(final String message)
    {
        printStream.println(message);
    }
}
