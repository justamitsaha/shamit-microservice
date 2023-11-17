package com.saha.amit.springBasic.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class FootballCoach implements Coach{

    Logger logger = LoggerFactory.getLogger(FootballCoach.class);
    public static int i;

    FootballCoach(){
        i++;
        logger.info("football coach initialization --> "+i);
    }

    @PostConstruct
    public void doMyStartupStuff() {
        logger.info("In doMyStartupStuff(): " + getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanupStuff() {
        logger.info("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }
    @Override
    public String getWorkOut() {
        return "Dribble for 15 minutes";
    }
}
