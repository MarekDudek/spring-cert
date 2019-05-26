package com.marekdudek.springcert.factories;

import org.springframework.beans.factory.FactoryBean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class MessageDigestFactory implements FactoryBean<MessageDigest>
{
    private final MessageDigest instance;

    public MessageDigestFactory(final String algorithm) throws NoSuchAlgorithmException
    {
        instance = MessageDigest.getInstance(algorithm);
    }

    @Override
    public MessageDigest getObject() throws Exception
    {
        return instance;
    }

    @Override
    public Class<MessageDigest> getObjectType()
    {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton()
    {
        return true;
    }
}
