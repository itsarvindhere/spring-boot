package com.myapp.util;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice pitching for 10 minutes!";
    }
}
