package com.saha.amit.springBasic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowExceptionAdvice {
    Logger log = LoggerFactory.getLogger(AfterThrowExceptionAdvice.class);
    @AfterThrowing(pointcut = "execution(* throwException(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        String method = theJoinPoint.getSignature().toShortString();
        log.info("\n=====>>> Executing @AfterThrowing on method: " + method);

        log.info("\n=====>>> The exception is: " + theExc);
    }
}
