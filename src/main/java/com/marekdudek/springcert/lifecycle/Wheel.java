package com.marekdudek.springcert.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static com.google.common.base.Preconditions.checkArgument;

class Wheel implements ApplicationContextAware
{
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(final ApplicationContext ctx) throws BeansException
    {
        this.ctx = ctx;
    }

    @PostConstruct
    void postConstruct()
    {
        checkArgument(ctx.containsBean("cycling"));

        try
        {
            ctx.getBean(Cycling.class);
        }
        catch (final BeanCurrentlyInCreationException e)
        {
            // intentionally left blank
        }
    }

    private Cycling cycling;

    void setCycling(final Cycling cycling)
    {
        this.cycling = cycling;
    }

    @PreDestroy
    void preDestroy()
    {
        checkArgument(cycling.stopped);
    }
}
