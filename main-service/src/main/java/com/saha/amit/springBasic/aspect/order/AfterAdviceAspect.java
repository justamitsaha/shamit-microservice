package com.saha.amit.springBasic.aspect.order;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAdviceAspect {

    Logger log = LoggerFactory.getLogger(AfterAdviceAspect.class);
    @After("execution(* afterAdvice(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        log.info("\n=====>>> Executing @After (finally) on method: " + method);
    }
}
