package com.myapp.demo.controller;

import com.myapp.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//    Field Injection
//    @Autowired
    private Coach coach;

//    Constructor Injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        this.coach = coach;
    }

//    Setter Injection
//    @Autowired
//    public void getCoach(@Qualifier("coach") Coach coach) {
//        this.coach = coach;
//    }

    @GetMapping("/dailyworkout")
    String getWorkout() {
        return coach.getDailyWorkout();
    }
}
