package com.study.microservices_configurations.controller;

import com.study.microservices_configurations.config.DBSettingsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Profile("test")
@RefreshScope
public class GreetingsController {

    @Value("${greeting.message:defaultMessage}")
    private String greetingMessage;

    @Value("Static message")
    private String staticMessage;

    @Value("${greeting.to.list}")
    private List<String> members;

    @Value("#{${db.connectionParams}}")
    private Map<String, String> dbParams;

    @Autowired
    private DBSettingsConfig dbSettingsConfig;

    @Autowired
    private Environment environment;
    @GetMapping("/greeting")
    public String getGreetings() {
        return this.greetingMessage + " " + this.staticMessage
                + " " + members + " " + dbParams + "\n" + dbSettingsConfig;
    }

    @GetMapping("/env")
    public String getEnvDets() {
        return this.environment.toString();
    }
}
