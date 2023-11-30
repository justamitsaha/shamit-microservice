package com.saha.amit.springBasic.aspect.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    Logger log = LoggerFactory.getLogger(MyApiAnalyticsAspect.class);
    @Before("com.saha.amit.springBasic.aspect.order.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        log.info("\n=====>>> Performing API analytics");
    }

}
