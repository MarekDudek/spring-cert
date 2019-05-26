package com.marekdudek.springcert.factories;

import org.springframework.beans.factory.FactoryBean;

final class PolymorphicFactory implements FactoryBean<Object>
{
    private final Object instance;

    public PolymorphicFactory(final Object instance)
    {
        this.instance = instance;
    }

    @Override
    public Object getObject()
    {
        return instance;
    }

    @Override
    public Class<?> getObjectType()
    {
        return instance.getClass();
    }
}
