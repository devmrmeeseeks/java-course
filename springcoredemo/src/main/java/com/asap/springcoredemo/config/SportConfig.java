package com.asap.springcoredemo.config;

import com.asap.springcoredemo.common.Coach;
import com.asap.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
