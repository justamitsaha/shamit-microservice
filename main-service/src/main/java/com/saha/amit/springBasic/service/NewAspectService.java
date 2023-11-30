package com.saha.amit.springBasic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NewAspectService {

    Logger log = LoggerFactory.getLogger(NewAspectService.class);
    public void doStuff(){
        log.info("Doing Stuff in NewAspectService");
    }

    public void addHeroes(){
        log.info("Adding heroes in NewAspectService");
    }

    public boolean subtractThings(){
        log.info("Subtract boolean in NewAspectService");
        return  true;
    }
}
