package com.saha.amit.springBasic.config;

import com.saha.amit.springBasic.component.PlayGround;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Congfig {

    @Bean
    public PlayGround playGround(){
        return new PlayGround();
    }
}
