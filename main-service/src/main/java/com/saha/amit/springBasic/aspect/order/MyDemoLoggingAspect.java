package com.saha.amit.springBasic.aspect.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    Logger log = LoggerFactory.getLogger(MyDemoLoggingAspect.class);
    @Before("com.saha.amit.springBasic.aspect.order.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        log.info("\n=====>>> Executing @Before advice on method");
    }

}