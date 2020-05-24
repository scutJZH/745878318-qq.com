package com.jzh.study.springcloud.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient8081 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClient8081.class, args);
    }
}
