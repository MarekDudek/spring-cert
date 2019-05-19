package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessagePipeline;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class DefaultAction implements MessageAction
{
    private final MessageSupplier supplier;
    private final MessageConsumer consumer;
    private final MessagePipeline pipeline;

    @Autowired
    public DefaultAction
            (
                    final MessageSupplier supplier,
                    final MessageConsumer consumer,
                    final MessagePipeline pipeline
            )
    {
        this.supplier = supplier;
        this.consumer = consumer;
        this.pipeline = pipeline;
    }


    @Override
    public void run()
    {
        pipeline.run(supplier, consumer);
    }
}
