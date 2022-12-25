package com.study.microservices_configurations.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @Value("${greeting.message}")
    private String greetingMessage;

    @GetMapping("/greeting")
    public String getGreetings() {
        return this.greetingMessage;
    }
}
