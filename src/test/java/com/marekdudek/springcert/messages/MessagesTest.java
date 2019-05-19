package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.ConstMessageSupplier;
import com.marekdudek.springcert.messages.implementations.PrintStreamMessageConsumer;
import com.marekdudek.springcert.messages.implementations.RunCountOfTimesPipeline;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessagePipeline;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.Test;

final class MessagesTest
{
    @Test
    void test()
    {
        // given
        final MessageSupplier supplier = new ConstMessageSupplier("some message");
        final MessageConsumer consumer = new PrintStreamMessageConsumer(System.out);
        final MessagePipeline pipeline = new RunCountOfTimesPipeline(3);
        // when
        pipeline.run(supplier, consumer);
    }
}
