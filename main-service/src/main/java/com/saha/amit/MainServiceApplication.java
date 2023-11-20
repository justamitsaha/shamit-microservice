package com.saha.amit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope
//@EnableEurekaClient
@EnableSwagger2
public class MainServiceApplication {

    Logger logger = LoggerFactory.getLogger(MainServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MainServiceApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        logger.info("http://localhost:8080/mainService/swagger-ui.html#/");
        return new Docket(DocumentationType.SPRING_WEB.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.saha.amit")).build();
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