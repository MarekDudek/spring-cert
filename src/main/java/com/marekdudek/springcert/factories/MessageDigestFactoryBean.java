package com.marekdudek.springcert.factories;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

@Component
class MessageDigestFactoryBean implements FactoryBean<MessageDigest>
{
    @Override
    public MessageDigest getObject() throws Exception
    {
        return MessageDigest.getInstance("MD5");
    }

    @Override
    public Class<MessageDigest> getObjectType()
    {
        return MessageDigest.class;
    }
}
