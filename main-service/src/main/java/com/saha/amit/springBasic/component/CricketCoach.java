package com.saha.amit.springBasic.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary  // To provide default bean when multiple options exist note @Qualifier  overrides @Primary
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {
    Logger logger = LoggerFactory.getLogger(CricketCoach.class);
    public static int i;

    CricketCoach() {
        i++;
        logger.info(this.getClass().getSimpleName() + " initialized");
    }

    @Override
    public String getWorkOut() {
        return "Bowl for 15 minutes";
    }
}
