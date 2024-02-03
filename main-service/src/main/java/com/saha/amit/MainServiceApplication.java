package com.saha.amit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope
//@EnableEurekaClient

public class MainServiceApplication {

    Logger logger = LoggerFactory.getLogger(MainServiceApplication.class);

    public static void main(String[] args) {
        System.out.println("Swagger URL http://localhost:8080/mainService/swagger-ui/index.html#/");
        SpringApplication.run(MainServiceApplication.class, args);
    }



//    @Bean
//    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//        return runner -> {
//            Faker faker = Faker.instance();
//            Students students = new Students(faker.name().firstName(), faker.name().lastName(), faker.name().firstName() + "@" + faker.name().lastName() + ".com");
//            studentDAO.saveStudent(students);
//            logger.info("Save Students --> "+ students.toString());
//
//            int num = faker.number().numberBetween(1,6);
//            logger.info("Get Student with id "+ num +" --> "+studentDAO.findStudentById(num).toString());
//
//        };
//    }
}