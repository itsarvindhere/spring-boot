package com.myapp.util;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice dribbling for 20 minutes!";
    }
}
