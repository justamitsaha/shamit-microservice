package com.saha.amit.springBasic.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saha.amit.springBasic.dao.Giraffe;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadAfterAspect {
    Logger log = LoggerFactory.getLogger(ReadAfterAspect.class);
    @AfterReturning(
            pointcut = "execution(* methodArgumentsWithJoinPoint(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, Giraffe result) throws JsonProcessingException {
        String method = theJoinPoint.getSignature().toShortString();
        log.info("\n=====>>> Executing @AfterReturning on method: " + method);
        String json = new ObjectMapper().writeValueAsString(result);
        log.info(json);
    }
}
