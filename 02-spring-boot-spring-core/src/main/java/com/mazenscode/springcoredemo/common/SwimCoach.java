package com.mazenscode.springcoredemo.common;

public class SwimCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "swim 1000 meters as a warmup";
    }

    // In This class we didnt annotate it with @Component, instead we configured as a spring bean using @Bean in SportConfig class

}
