package com.jzh.study.springcloud.eureka_consumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class EurekaConsumerController {
    private String EUREKA_CLIENT_URL = "http://EUREKA-CLIENT";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping
    public String consume() {
        ResponseEntity<String> result = restTemplate.getForEntity(EUREKA_CLIENT_URL + "/test", String.class);
        return "this is consumer80" + result.getBody();
    }
}
