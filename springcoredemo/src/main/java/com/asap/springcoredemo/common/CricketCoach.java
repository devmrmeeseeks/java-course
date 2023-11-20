package com.asap.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructoin: " + this.getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast blowing for 18 minutes";
    }
}
