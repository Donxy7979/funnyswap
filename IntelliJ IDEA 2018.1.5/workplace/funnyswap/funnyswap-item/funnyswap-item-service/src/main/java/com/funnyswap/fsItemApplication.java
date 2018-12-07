package com.funnyswap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = {"com.funnyswap.dao"})
public class fsItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(fsItemApplication.class);
    }
}
