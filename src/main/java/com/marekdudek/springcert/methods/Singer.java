package com.marekdudek.springcert.methods;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

import static java.lang.System.out;

@Component
@Scope("prototype")
class Singer
{
    private final int number = new Random().nextInt();

    void sing()
    {
        out.println("singer " + number);
    }
}
