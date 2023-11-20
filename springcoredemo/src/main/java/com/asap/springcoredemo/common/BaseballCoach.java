package com.asap.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("In constructoin: " + this.getClass().getName());
    }

//    @PostConstruct
//    public void doMyStartupStuff() {
//        System.out.println("BaseballCoach: inside method doMyStartupStuff");
//    }
//
//    @PreDestroy
//    public void doMyCleanupStuff() {
//        System.out.println("BaseballCoach: inside method doMyCleanupStuff");
//    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
