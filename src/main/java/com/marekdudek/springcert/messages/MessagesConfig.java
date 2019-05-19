package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.ConstMessageSupplier;
import com.marekdudek.springcert.messages.implementations.PrintStreamMessageConsumer;
import com.marekdudek.springcert.messages.implementations.RunCountOfTimesAction;
import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/messages.properties")
class MessagesConfig
{

    @Value("${messages.message}")
    private String message;

    @Value("${messages.count}")
    private int count;

    @Bean
    String message()
    {
        return message;
    }

    @Bean
    Integer count()
    {
        return count;
    }

    @Bean
    MessageSupplier supplier()
    {
        return new ConstMessageSupplier(message());
    }

    @Bean
    MessageConsumer consumer()
    {
        return new PrintStreamMessageConsumer(System.out);
    }


    @Bean
    MessageAction actionOne()
    {
        return new RunCountOfTimesAction(supplier(), consumer(), count());
    }

    @Bean
    MessageAction actionTwo()
    {
        return new RunCountOfTimesAction(supplier(), consumer(), count());
    }
}
