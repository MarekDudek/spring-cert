package com.marekdudek.springcert.messages.interfaces;

public interface MessagePipeline
{
    void run(MessageSupplier supplier, MessageConsumer consumer);
}
