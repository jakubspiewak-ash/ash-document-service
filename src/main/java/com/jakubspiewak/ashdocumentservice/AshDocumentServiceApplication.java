package com.jakubspiewak.ashdocumentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AshDocumentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AshDocumentServiceApplication.class, args);
    }

}
