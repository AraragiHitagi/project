package com.how2java.service;
import org.aspectj.lang.ProceedingJoinPoint;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PerformanceAspect {
    public Object performance(ProceedingJoinPoint joinPoint) throws Throwable {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        Object object = joinPoint.proceed();
        System.out.println(df.format(new Date()));
        return object;
    }
}
