package com.funnyswap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class fsRegistry {
    public static void main(String[] args) {
        SpringApplication.run(fsRegistry.class);
    }
}
