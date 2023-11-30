package com.saha.amit.springBasic.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    Logger log = LoggerFactory.getLogger(MyAspect.class);

    @Before("execution(void doStuff())")                //Point cut expression which will work on doStuff method
    public void beforeDoStuff(){                        //Advise
        log.info("Housekeeping before do stuff");
    }

    @Before("execution(void com.saha.amit.springBasic.service.AspectService.doStuff())")  //Point cut expression will work only on AspectService doStuff method
    public void beforeDoStuffInAspectService(){
        log.info("Housekeeping before do stuff only in AspectService");
    }

    @Before("execution(void add*())")  //Point cut expression will work only on function with add in name
    public void beforeAddThings(){
        log.info("Housekeeping before Add things");
    }

    @Before("execution(boolean subtract*())")  //Point cut expression will work only on function with subtract in name and boolean return type
    public void subtractThingsBoolean(){
        log.info("Housekeeping before boolean subtractThings");
    }

    @Before("execution(* subtract*())")  //Point cut expression will work only on function with subtract in name and any return type
    public void subtractThingsAny(){
        log.info("Housekeeping before any subtractThings");
    }

    @Before("execution(* addAccount(com.saha.amit.springBasic.service.AspectService))")      //Will match based on parameters
    public void beforeAddAccountAdvice1() {

        log.info("\n=====>>> Executing @Before advice on method");

    }

    @Before("execution(* add*(com.saha.amit.springBasic.service.AspectService, ..))")  //Match for Account and any number of param
    public void beforeAddAccountAdvice2() {

        log.info("\n=====>>> Executing @Before advice on method");

    }

//    @Before("execution(* add*(..))")        //Any number of params
//    public void beforeAddAccountAdvice3() {
//
//        System.out.println("\n=====>>> Executing @Before advice on method");
//
//    }

    @Before("execution(* com.saha.amit.springBasic.service.*.*(..))")   //all methods in a package
    public void beforeAddAccountAdvice4() {

        log.info("\n=====>>> Executing @Before advice on all method in service package");

    }






}
