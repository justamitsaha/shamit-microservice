package com.saha.amit.springBasic.component;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class FootballCoach implements Coach{

    public static int i;

    FootballCoach(){
        i++;
        System.out.println("football coach initialization --> "+i);
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }
    @Override
    public String getWorkOut() {
        return "Dribble for 15 minutes";
    }
}
