package com.marekdudek.springcert.lifecycle;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@RequiredArgsConstructor(onConstructor = @_(@Autowired))
class Cycling implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean
{
    @NonNull
    public final Wheel wheel;


    @Override
    public void setBeanName(final String name)
    {
        checkNotNull(wheel);
        this.name = name;
    }

    String name;


    @Override
    public void setApplicationContext(final ApplicationContext applicationContext)
    {
        checkNotNull(name);
        this.applicationContext = applicationContext;
    }

    private ApplicationContext applicationContext;


    @PostConstruct
    void postConstruct()
    {
        checkNotNull(applicationContext);
        constructed = true;
    }

    private boolean constructed;


    @Override
    public void afterPropertiesSet() throws Exception
    {
        checkArgument(constructed);
        propertiesSet = true;
    }

    private boolean propertiesSet;


    void start()
    {
        checkArgument(propertiesSet);
        started = true;
    }

    private boolean started;


    @PreDestroy
    void preDestroy()
    {
        checkArgument(started);
        preDestroyed = true;
    }

    private boolean preDestroyed;


    @Override
    public void destroy() throws Exception
    {
        checkArgument(preDestroyed);
        destroyed = true;
    }

    private boolean destroyed;


    void stop()
    {
        checkArgument(destroyed);
        stopped = true;
    }

    private boolean stopped;
}
