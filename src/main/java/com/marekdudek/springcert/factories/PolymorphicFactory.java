package com.marekdudek.springcert.factories;

import org.springframework.beans.factory.FactoryBean;

final class PolymorphicFactory<T> implements FactoryBean<T>
{
    private final T instance;

    public PolymorphicFactory(final T instance)
    {
        this.instance = instance;
    }

    @Override
    public T getObject()
    {
        return instance;
    }

    @Override
    public Class<?> getObjectType()
    {
        return instance.getClass();
    }
}
