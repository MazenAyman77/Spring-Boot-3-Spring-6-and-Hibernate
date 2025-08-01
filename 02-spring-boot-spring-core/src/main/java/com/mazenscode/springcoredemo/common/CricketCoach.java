package com.mazenscode.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component // marks the class as a spring bean, it makes it a candidate for dependency injection
@Lazy
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "run 15 kilometers !!!!!!!!!!";
    }

}
