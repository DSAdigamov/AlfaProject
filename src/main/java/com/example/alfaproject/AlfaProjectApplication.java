package com.example.alfaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AlfaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlfaProjectApplication.class, args);
    }



}
