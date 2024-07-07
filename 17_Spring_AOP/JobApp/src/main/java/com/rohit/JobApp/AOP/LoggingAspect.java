package com.rohit.JobApp.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execute(* com.rohit.JobApp.service.JobService.*(..)")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called "+jp.getSignature().getName());
    }

    @After("execution (* com.rohit.JobApp.service.JobService.getJob*(..)) || execution(* com.rohit.JobApp.service.JobService.updateJob*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed "+jp.getSignature().getName());
    }


    @AfterThrowing("execute(* com.rohit.JobApp.service.JobService.*(..)")
    public void logMethodCrashed(JoinPoint jp) {
        LOGGER.info("Method has some issues "+jp.getSignature().getName());
    }



    @AfterReturning("execute(* com.rohit.JobApp.service.JobService.*(..)")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
    }

}
