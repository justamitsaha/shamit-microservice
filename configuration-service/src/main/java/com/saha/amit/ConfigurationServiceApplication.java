package com.saha.amit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationServiceApplication {
    public static void main(String[] args) {
        System.out.println("Local URL --> http://localhost:9000/configurationService/discovery-service/default");
        SpringApplication.run(ConfigurationServiceApplication.class,args);
    }
}