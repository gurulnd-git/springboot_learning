package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    @Autowired
    Environment environment;

    public void getP() {
        System.out.println(environment.getProperty("datasource.username"));
    }

}
