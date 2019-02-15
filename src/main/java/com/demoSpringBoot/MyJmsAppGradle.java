package com.demoSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MyJmsAppGradle {

    public static void main(String[] args) {
        SpringApplication.run(MyJmsAppGradle.class, args);
    }

}