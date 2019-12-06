package com.study.javastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.study")
public class JavaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaStudyApplication.class, args);
        System.out.println(".....service start ...");
    }

}
