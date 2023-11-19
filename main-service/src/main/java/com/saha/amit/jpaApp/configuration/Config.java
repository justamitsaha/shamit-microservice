package com.saha.amit.jpaApp.configuration;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
