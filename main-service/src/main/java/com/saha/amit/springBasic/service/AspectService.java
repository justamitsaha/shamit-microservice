package com.saha.amit.springBasic.service;

import com.saha.amit.springBasic.dao.Giraffe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    public void methodArgumentsWithJoinPoint(String str, int i, Giraffe giraffe){
        log.info("Reading method with params");
    }

    

}
