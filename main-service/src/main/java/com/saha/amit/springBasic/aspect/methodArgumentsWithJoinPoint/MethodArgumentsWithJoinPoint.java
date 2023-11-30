package com.saha.amit.springBasic.aspect.methodArgumentsWithJoinPoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saha.amit.springBasic.dao.Giraffe;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodArgumentsWithJoinPoint {
    Logger log = LoggerFactory.getLogger(MethodArgumentsWithJoinPoint.class);

    @Before("execution(void methodArgumentsWithJoinPoint(..))")
    public void methodArgumentsWithJoinPoint(JoinPoint theJoinPoint) throws JsonProcessingException {

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        log.info("Printing method signature before execution" + methodSignature);
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Giraffe) {
                String json = new ObjectMapper().writeValueAsString(tempArg);
                log.info(json);
            } else
                log.info(tempArg.toString());
        }
    }
}
