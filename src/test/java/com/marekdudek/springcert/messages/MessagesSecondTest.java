package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.interfaces.MessageAction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
final class MessagesSecondTest
{
    @Autowired
    private MessageAction defaultAction;

    @Test
    void test()
    {
        defaultAction.run();
    }
}
