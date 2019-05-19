package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessagePipeline;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
final class MessagesSpringBootTest
{
    @Autowired
    private MessageSupplier supplier;
    @Autowired
    private MessageConsumer consumer;
    @Autowired
    private MessagePipeline pipeline;

    @Test
    void test()
    {
        pipeline.run(supplier, consumer);
    }

    @Test
    void test(@Autowired final Runnable action)
    {
        action.run();
    }
}
