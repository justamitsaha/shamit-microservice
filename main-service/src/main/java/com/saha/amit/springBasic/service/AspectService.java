package com.saha.amit.springBasic.service;

import com.github.javafaker.Faker;
import com.saha.amit.springBasic.dao.Giraffe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class AspectService {

    Logger log = LoggerFactory.getLogger(AspectService.class);

    public void doStuff(){
        log.info("Doing Stuff in AspectService");
    }

    public void addThings(){
        log.info("Adding things in AspectService");
    }

    public void subtractThings(){
        log.info("Subtract things in AspectService");
    }

    public void order(){
        log.info("Aspects in order");
    }

    public Giraffe methodArgumentsWithJoinPoint(String str, int i, Giraffe giraffe){
        log.info("Reading method with params");
        return new Giraffe("Python", 2,4,1,"Small");
    }

    public void throwException() throws FileNotFoundException {
        log.info("Throwing exception");
        throw new FileNotFoundException("Dummy file not found");
    }


    public void afterAdvice() throws FileNotFoundException {
        log.info("Throwing exception");
        int i = Faker.instance().number().numberBetween(1,10);
        if(i%2==0){
            throw new FileNotFoundException("Dummy file not found"+ i);
        }
    }

    public String aroundAdvice() {
        log.info("Inside aroundAdvice");
        return "aroundAdvice";
    }

    public String  aroundAdviceHandelException() {
        throw new RuntimeException();
    }
}
