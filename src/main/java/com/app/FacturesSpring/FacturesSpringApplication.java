package com.app.FacturesSpring;

import com.app.FacturesSpring.model.Client;
import com.app.FacturesSpring.service.ClientService;
import com.app.FacturesSpring.service.FactureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FacturesSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacturesSpringApplication.class, args);
    }

}
