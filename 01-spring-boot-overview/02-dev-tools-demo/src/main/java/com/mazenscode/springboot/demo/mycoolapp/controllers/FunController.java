package com.mazenscode.springboot.demo.mycoolapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

    @GetMapping("/")
    public String hello(){
        return "hello mazen";
    }

    @GetMapping("/workout")
    public String workout(){
        return "run a hard 5k!";
    }

    @Value("${team.name}")
    private String teameName;

    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return teameName + " " + coachName;
    }


}
