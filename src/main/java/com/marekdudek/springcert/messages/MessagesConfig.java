package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.ConstMessageSupplier;
import com.marekdudek.springcert.messages.implementations.PrintStreamMessageConsumer;
import com.marekdudek.springcert.messages.implementations.RunCountOfTimesPipeline;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessagePipeline;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MessagesConfig
{
    @Bean
    MessageSupplier supplier()
    {
        return new ConstMessageSupplier("some message");
    }

    @Bean
    MessageConsumer consumer()
    {
        return new PrintStreamMessageConsumer(System.out);
    }

    @Bean
    MessagePipeline pipeline()
    {
        return new RunCountOfTimesPipeline(3);
    }

    @Bean
    Runnable actionOne()
    {
        System.out.println("action 1");
        return () -> pipeline().run(supplier(), consumer());
    }

    @Bean
    Runnable actionTwo()
    {
        System.out.println("action 2");
        return () -> pipeline().run(supplier(), consumer());
    }
}