package com.jzh.study.springcloud.eureka_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer80.class, args);
    }
}
