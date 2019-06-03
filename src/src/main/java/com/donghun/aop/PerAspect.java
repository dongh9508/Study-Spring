package com.donghun.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerAspect {

//    @Around("@annotation(PerLogging)")
    @Around("bean(simpleEventService)")
    public Object logPerf(ProceedingJoinPoint pip) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pip.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("hello");
    }
}
