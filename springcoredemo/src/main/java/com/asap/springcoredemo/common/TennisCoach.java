package com.asap.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("In constructoin: " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
