package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.ConstMessageSupplier;
import com.marekdudek.springcert.messages.implementations.PrintStreamMessageConsumer;
import com.marekdudek.springcert.messages.implementations.RunCountOfTimesPipeline;
import com.marekdudek.springcert.messages.interfaces.MessageAction;
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
    MessageAction actionOne()
    {
        return () -> pipeline().run(supplier(), consumer());
    }

    @Bean
    MessageAction actionTwo()
    {
        return () -> pipeline().run(supplier(), consumer());
    }
}
