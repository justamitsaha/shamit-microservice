package com.saha.amit.springBasic.controller;

import com.saha.amit.springBasic.component.Coach;
import com.saha.amit.springBasic.component.PlayGround;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
public class SpringController {


    //@Autowired // Field injection not recommended
    private Coach coach;
    private Coach assistantCoach;
    private Coach anotherCoach;
    private PlayGround playGround;

    //Constructor injection if only once constructor then @Autowired is optional
    @Autowired
    public SpringController(
            @Qualifier("footballCoach") Coach coach,        //To explicitly tell which bean to load
            @Qualifier("cricketCoach") Coach anotherCoach,
            @Qualifier("cricketCoach") Coach assistantCoach,
            PlayGround playGround) {  // @Qualifier  overrides @Primary
        this.coach = coach;
        this.assistantCoach = assistantCoach;
        this.anotherCoach = anotherCoach;
        this.playGround = playGround;
    }

    //Setter injection
//    @Autowired
//    public void setCoach(Coach coach){
//        this.coach = coach;
//    }

    @GetMapping("/getWorkOut")
    public String getWorkOut() {
        return coach.getWorkOut();
    }

    @GetMapping("/checkBeans")
    public String checkBeans() {
        return assistantCoach.getWorkOut() + " " + (coach == assistantCoach) + " " + (anotherCoach == assistantCoach);
        //Even tough Cricket coach is singleton still anotherCoach== assistantCoach  is true
    }

    @GetMapping("/playGround")
    public String playGround() {
        return playGround.getPlayGround();
    }

}
