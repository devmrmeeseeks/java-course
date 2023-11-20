package com.asap.aopdemo.service;

import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        return getFortune(false);
    }

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Major accident! Highway is closed!");
        }

        try {
            Thread.sleep(Duration.ofSeconds(5).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic this morning";
    }
}
