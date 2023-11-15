package com.saha.amit.springBasic.component;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary  // To provide default bean when multiple options exist note @Qualifier  overrides @Primary
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {

    public static int i;

    CricketCoach() {
        i++;
        System.out.println(this.getClass().getSimpleName() + " initialized");
    }

    @Override
    public String getWorkOut() {
        return "Bowl for 15 minutes";
    }
}
