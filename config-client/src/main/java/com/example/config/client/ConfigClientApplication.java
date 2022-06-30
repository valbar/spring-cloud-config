package com.example.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConfigClientApplication {

    @Value("${common.config}")
    private String config;

    @Value("${common.ver}")
    private String ver;

    @Value("${env.config}")
    private String envConfig;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {
            System.out.println("");
            System.out.println("------");
            System.out.println("${common.config} : " + config);
            System.out.println("${common.ver} : " + ver);
            System.out.println("${env.config} : " + envConfig);
            System.out.println("------");
            System.out.println("");
        };
    }
}
