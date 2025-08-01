package com.mazenscode.springcoredemo.config;

import com.mazenscode.springcoredemo.common.Coach;
import com.mazenscode.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") // aquatic is an optional id
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
