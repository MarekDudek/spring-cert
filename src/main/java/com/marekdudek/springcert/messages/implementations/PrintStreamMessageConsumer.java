package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Builder
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
