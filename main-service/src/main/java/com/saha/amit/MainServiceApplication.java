package com.saha.amit;

import com.github.javafaker.Faker;
import com.saha.amit.jpaApp.dao.StudentDAO;
import com.saha.amit.jpaApp.dto.Students;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope
//@EnableEurekaClient
public class MainServiceApplication {

    Logger logger = LoggerFactory.getLogger(MainServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MainServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            Faker faker = Faker.instance();
            Students students = new Students(faker.name().firstName(), faker.name().lastName(), faker.name().firstName() + "@" + faker.name().lastName() + ".com");
            logger.info("Students --> "+ students.toString());
            studentDAO.saveStudent(students);
        };
    }
}