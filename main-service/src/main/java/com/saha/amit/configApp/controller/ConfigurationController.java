package com.saha.amit.configApp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    @Value("${my.name}")  //java -jar main-service-2.7.14.jar  --my.name="Amit" for passing argument during runtime
    private String name;

    @Value("${my.greeting :how are you?}")   //default value
    private String greeting;

    @Value("${weekDays}")
    private List<String> days;

    @GetMapping("getStringFromFile")
    public String getStringFromFile(){
        return "hello "+ name + " "+ greeting ;
    }

    @GetMapping(value ="getDaysOdWeek", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getDaysOdWeek(){
        return Flux.fromIterable(days)
                .delayElements(Duration.ofSeconds(2))
                .map(s -> "Today is "+s);
    }
}
