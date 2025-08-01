package com.mazenscode.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
// The default bean scope is singleton, but if you want to change it write this @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {

        return "pass 250 ball";

    }

}
