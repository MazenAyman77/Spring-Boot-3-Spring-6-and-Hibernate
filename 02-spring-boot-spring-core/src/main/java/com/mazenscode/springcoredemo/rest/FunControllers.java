package com.mazenscode.springcoredemo.rest;

import com.mazenscode.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunControllers {

    private Coach coach;
    private Coach anotherCoach;

    @Autowired // tells spring to inject the dependency
                // @AutoWired is optional if you have only one constructor
    // This is a constructor Injection
    // We Used @Qualifier cuz we have multiple beans which implements Coach class so spring should know which to inject
    public FunControllers(
            @Qualifier("aquatic") Coach coach,
            @Qualifier("footballCoach") Coach anotherCoach){
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    /*
    @AutoWired
    *** Setter Injection ***
    public void setCoach(Coach coach){
      this.coach = coach;
    }
    */

    @GetMapping("/getWorkout")
    public String getWorkout(){
        return coach.getDailyWorkout();
    }

    // Checking the beans scopes, should return true cuz they both are singleton scopes
    @GetMapping("/check")
    public String checkScopes(){
        return "Comparing scopes of beans : coach == another coach is ==> " + (coach == anotherCoach) ;
    }

}
