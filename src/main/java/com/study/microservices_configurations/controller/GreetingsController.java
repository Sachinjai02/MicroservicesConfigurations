package com.study.microservices_configurations.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingsController {

    @Value("${greeting.message:defaultMessage}")
    private String greetingMessage;

    @Value("Static message")
    private String staticMessage;

    @Value("${greeting.to.list}")
    private List<String> members;

    @Value("#{${dbParams}}")
    private Map<String, String> dbParams;
    @GetMapping("/greeting")
    public String getGreetings() {
        return this.greetingMessage + " " + this.staticMessage
                + " " + members + " " + dbParams;
    }
}
