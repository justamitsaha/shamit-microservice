package com.saha.amit.springBasic.controller;

import com.saha.amit.springBasic.dao.Giraffe;
import com.saha.amit.springBasic.service.AspectService;
import com.saha.amit.springBasic.service.NewAspectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aop")
public class AOPController {

    @Autowired
    AspectService aspectService;
    @Autowired
    NewAspectService newAspectService;

    Logger log = LoggerFactory.getLogger(AOPController.class);
    @GetMapping("/advise")
    public String checkBeans() {
        aspectService.doStuff();
        newAspectService.doStuff();
        return "hello";
    }


    @GetMapping("/wildcardPointCut")
    public String wildcardPointCut() {
        aspectService.addThings();
        newAspectService.addHeroes();
        aspectService.subtractThings();
        return "hello";
    }

    @GetMapping("/returnTypePointCut")
    public String returnTypePointCut() {
        newAspectService.subtractThings();
        aspectService.subtractThings();
        return "hello";
    }

    @GetMapping("/order")
    public String order() {
        aspectService.order();
        return "hello";
    }


    @GetMapping("/methodArgumentsWithJoinPoint")
    public String methodArgumentsWithJoinPoint() {
        Giraffe giraffe = new Giraffe("Monty", 2,4,1,"Long");
        aspectService.methodArgumentsWithJoinPoint("Hello",2,giraffe);
        return "hello";
    }


}
