package com.myapp.demo.controller;

import com.myapp.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    private Coach coach;

//    Constructor Injection
//    @Autowired
//    public DemoController(Coach coach) {
//        this.coach = coach;
//    }

//    Setter Injection
    @Autowired
    public void getCoach(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    String getWorkout() {
        return coach.getDailyWorkout();
    }
}
