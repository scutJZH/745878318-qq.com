package com.jzh.study.springcloud.eureka_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class EurekaController {
    @GetMapping
    public String getMessage() {
        return "8081 result";
    }
}
